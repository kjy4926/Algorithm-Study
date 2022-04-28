package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N2178{
	int x;
	int y;
	int c;
	
	N2178(int x, int y, int c){
		this.x = x;
		this.y = y;
		this.c = c;
	}
}

public class Backjoon2178 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n; // x
	static int m; // y
	static int count = Integer.MAX_VALUE;
	static int[] dx = {-1,1,0,0}; // ╩С го аб ©Л
	static int[] dy = {0,0,-1,1}; // ╩С го аб ©Л
	static boolean[][] map = new boolean[100][100];
	static boolean[][] visit = new boolean[100][100];
	
	public static void bfs() {
		Queue<N2178> q = new LinkedList<N2178>();
		q.add(new N2178(0,0,1));
		while(!q.isEmpty()) {
			N2178 node = q.poll();
			if(node.x == n-1 && node.y == m-1) {
				System.out.println(node.c);
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && !visit[nx][ny] && map[nx][ny]) {
					q.add(new N2178(nx, ny, node.c+1));
					visit[nx][ny] = true; // ╧Ф╧╝
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
			for(int i=0;i<n;i++) {
				String input = br.readLine();
				for(int j=0;j<m;j++) {
					int k = Character.getNumericValue(input.charAt(j));
					if(k==1) {
						map[i][j] = true;
					}
					else {visit[i][j] = true;}
				}
			}
			visit[0][0] = true;
			bfs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}