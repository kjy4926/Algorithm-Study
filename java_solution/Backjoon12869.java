package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon12869 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] scv = new int[3]; // scv ÀÔ·Â
	static int[][][] visited = new int[61][61][61]; // dp
	
	public static int dfs(int scv1, int scv2, int scv3) {
		if(scv1<0) return dfs(0, scv2, scv3);
		if(scv2<0) return dfs(scv1, 0, scv3);
		if(scv3<0) return dfs(scv1, scv2, 0);
		
		if(visited[scv1][scv2][scv3] != -1) return visited[scv1][scv2][scv3];
		
		if(scv1 == 0 && scv2 == 0 && scv3 == 0) {
			return 0;
		}
		
		// Àç±Í depth +1 ÇÏ¸ç È½¼ö ÃøÁ¤
		visited[scv1][scv2][scv3] = 10000;
		visited[scv1][scv2][scv3] = Math.min(visited[scv1][scv2][scv3], dfs(scv1-9, scv2-3, scv3-1)+1);
		visited[scv1][scv2][scv3] = Math.min(visited[scv1][scv2][scv3], dfs(scv1-9, scv2-1, scv3-3)+1);
		visited[scv1][scv2][scv3] = Math.min(visited[scv1][scv2][scv3], dfs(scv1-3, scv2-1, scv3-9)+1);
		visited[scv1][scv2][scv3] = Math.min(visited[scv1][scv2][scv3], dfs(scv1-3, scv2-9, scv3-1)+1);
		visited[scv1][scv2][scv3] = Math.min(visited[scv1][scv2][scv3], dfs(scv1-1, scv2-9, scv3-3)+1);
		visited[scv1][scv2][scv3] = Math.min(visited[scv1][scv2][scv3], dfs(scv1-1, scv2-3, scv3-9)+1);
		
		return visited[scv1][scv2][scv3];
	}
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			StringTokenizer	st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				scv[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=n;i<3;i++) {
				scv[i] = 0;
			}
			for(int i=0;i<61;i++) {
				for(int j=0;j<61;j++) {
					Arrays.fill(visited[i][j], -1);
				}
			}
			System.out.println(dfs(scv[0], scv[1], scv[2]));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
