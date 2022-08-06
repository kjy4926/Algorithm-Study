package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1743 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] map = new boolean[100][100];
	static boolean[][] visit = new boolean[100][100];
	static int[] dx = {-1,1,0,0}; // »ó ÇÏ ÁÂ ¿ì
	static int[] dy = {0,0,-1,1}; // »ó ÇÏ ÁÂ ¿ì
	static int n; // x
	static int m; // y
	static int k;
	static int trash = 0; // return°ª
	static int count;
	static int max = 0;
	
	public static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<m && !visit[nx][ny] && map[nx][ny]) {
				visit[nx][ny] = true;
				dfs(nx, ny);
				count++;
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			String[] NMK = br.readLine().split(" ");
			n = Integer.parseInt(NMK[0]);
			m = Integer.parseInt(NMK[1]);
			k = Integer.parseInt(NMK[2]);
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				map[x][y] = true;
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] && !visit[i][j]) {
						count = 0;
						dfs(i, j);
						max = Math.max(max, count);
					}
				}
			}
			System.out.println(max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}