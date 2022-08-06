package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2616 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n; // 객차의 수
	static int[] nums; // 손님 배열
	static int k; // 소형객차의 최대 수용 수
	static int[] sum;
	static int[][] dp = new int[4][50001]; // dp[i][j] = 객차가 i대일때 j까지의 최댓값
	
	public static void solution() {
		for(int i=1;i<=3;i++) {
			for(int j=i*k;j<=n;j++) {
				// 직전 j-1까지의 최대값과 i-1대에서 j-k까지의 최대값 + j까지의 합 중 큰 값을 dp에 저장한다.
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k] + sum[j] - sum[j-k]);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			nums = new int[n+1];
			sum = new int [n+1];
			StringTokenizer	st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				nums[i+1] = Integer.parseInt(st.nextToken());
				sum[i+1] = sum[i] + nums[i+1];
			}
			k = Integer.parseInt(br.readLine());
			solution();
			System.out.println(dp[3][n]);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
