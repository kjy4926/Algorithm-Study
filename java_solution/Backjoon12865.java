package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon12865 {
	static int n;
	static int k;
	static int[] weight = new int[101];
	static int[] value = new int[101];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp = new int[101][100001]; // [i][k] i개의 물건을 넣어 무게 k일때의 가치
	static int[] dp2 = new int[100001]; // [k] 무게 k일때의 가치
	
	public static void main(String[] args) {
		try {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st1.nextToken());
			k = Integer.parseInt(st1.nextToken());
			
			for(int i=1;i<=n;i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int w = Integer.parseInt(st2.nextToken());
				int v = Integer.parseInt(st2.nextToken());
				weight[i] = w;
				value[i] = v;
			}
			// 방법 1
			// bottom-up
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=k;j++) {
					// i번째에 물건을 넣을 수 있다면
					if(j-weight[i] >= 0) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
					}
					else {
						dp[i][j] = dp[i-1][j]; 
					}
				}
			}
			// 방법 2(좀 더 효율 좋음)
			// 무게 k에 대하여 물건 i를 하나씩 넣어보며 최댓값 비교
			// top-down
			for(int i=1;i<=n;i++) {
				for(int j=k;j>=1;j--) {
					// 무게 j에 대하여 물건 i를 넣을 수 없다면 루프 중지
					if(j-weight[i]<0) {
						break;
					}
					dp2[j] = Math.max(dp2[j], dp2[j-weight[i]]+value[i]);
				}
			}
			// System.out.println(dp[n][k]);
			System.out.println(dp2[k]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}