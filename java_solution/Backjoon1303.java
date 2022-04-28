package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1303 {
	static int[] dx = {-1,1,0,0}; // 상 하 좌 우
	static int[] dy = {0,0,-1,1};
	static int[][] map = new int[100][100];
	static boolean[][] visit = new boolean[100][100];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n; // 가로
	static int m; // 세로
	static int blue = 0; // 파란색 위력
	static int white = 0; // 흰색 위력
	static int b = 0; // 파란색 인원 수
	static int w = 0; // 흰색 인원 수
	
	// type 0 : white / 1 : blue
	public static void dfs(int x, int y, int type) {
		// white
		if(type == 0 ) {
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx >=0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					w += 1;
					dfs(nx, ny, 0);
				}
			}
		}
		// blue
		else {
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx >=0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					b += 1;
					dfs(nx, ny, 1);
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			// map init
			for(int i=0; i<m; i++) {
				String line = br.readLine();
				for(int j=0; j<n; j++) {
					if(line.charAt(j) == 'W') {
						map[i][j] = 0;
					}
					else {
						map[i][j] = 1;
					}
				}
			}
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 0 && !visit[i][j]) {
						visit[i][j] = true;
						w = 1;
						dfs(i,j,0);
						white += w*w;
					}
					else if(map[i][j] == 1 && !visit[i][j]) {
						visit[i][j] = true;
						b = 1;
						dfs(i,j,1);
						blue += b*b;
					}
				}
			}
			System.out.printf("%d %d", white, blue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}