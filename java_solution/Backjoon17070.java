package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon17070 {
	static int type = 0; // 0-가로 / 1-세로 / 2-대각
	static boolean[][] map = new boolean[16][16]; // max = 16x16
	static int n;
	static int count = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void dfs(int x, int y, int type) {
		if(x == n-1 && y == n-1) {
			count++;
			return;
		}
		int nx;
		int ny;
		// 가로이동
		if(type != 1) {
			nx = x;
			ny = y+1;
			if(nx < n && ny < n && map[nx][ny] != true) {
				dfs(nx, ny, 0);
			}
		}
		// 세로이동
		if(type != 0) {
			nx = x+1;
			ny = y;
			if(nx < n && ny < n && map[nx][ny] != true) {
				dfs(nx, ny, 1);
			}
		}
		// 대각이동
		nx = x+1;
		ny = y+1;
		if(nx < n && ny < n && map[nx][ny] != true && map[x+1][y] != true && map[x][y+1] != true) {
			dfs(nx, ny, 2);
		}
	}
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			// map 초기화
			for(int i=0;i<n;i++) {
				StringTokenizer	st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					if(Integer.parseInt(st.nextToken())==1) {
						map[i][j] = true;
					}
				}
			}
			dfs(0, 1, 0);
			System.out.println(count);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}