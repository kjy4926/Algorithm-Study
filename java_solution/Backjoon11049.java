package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon11049 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] matrix;
	static int[][] dp = new int[501][501]; // dp[s][e] s번째에서 e번째까지 행렬곱셈 연산 최솟값
	// dp[s][e] = dp[s][i] + dp[i+1][e] + (matrix[s][0] * matrix[i][1] * matrix[e][1])
	// (matrix[s][0] * matrix[i][1] * matrix[e][1]) -> dp[s][i] * dp[i+1][e]의 연산 횟수
	
	public static int solution(int s, int e) {
		int result = 0;
		if(s==e) return 0;
		if(dp[s][e] != -1) return dp[s][e];
		if(e==s+1) {
			result = matrix[s][0] * matrix[s][1] * matrix[e][1];
			dp[s][e] = result;
			return dp[s][e];
		}
		for(int i=s;i<e;i++) {
			result = solution(s, i) + solution(i+1, e) + (matrix[s][0] * matrix[i][1] * matrix[e][1]);
			if(dp[s][e] == -1) dp[s][e] = result;
			else dp[s][e] = Math.min(dp[s][e], result);
		}
		return dp[s][e];
	}
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			matrix = new int[n+1][2];
			// matrix input
			for(int i=1;i<=n;i++) {
				StringTokenizer	st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				matrix[i][0] = x;
				matrix[i][1] = y;
			}
			for(int i=0;i<501;i++) {
				Arrays.fill(dp[i], -1);
			}
			System.out.println(solution(1,n));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}