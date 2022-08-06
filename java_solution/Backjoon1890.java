package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1890 {
	static int n;
	static int[][] map = new int[100][100];
	static long[][] dp = new long[100][100];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = 1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==0) continue;
					int nx = i+map[i][j];
					int ny = j+map[i][j];
					// 아래로 이동
					if(nx < n) {
						dp[nx][j] += dp[i][j];
					}
					// 오른쪽으로 이동
					if(ny < n) {
						dp[i][ny] += dp[i][j];
					}
				}
			}
			System.out.println(dp[n-1][n-1]);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}