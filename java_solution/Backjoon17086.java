package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N17086{
	int x;
	int y;
	int count;
	N17086(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Backjoon17086 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n; // x
	static int m; // y
	static int safety = 0;
	static boolean[][] graph = new boolean[50][50];
	static int[][] distance = new int[50][50];
	static int[] dx = {-1,-1,-1,0,1,1,1,0}; // 11시 방향부터 시게방향으로 회전
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	public static void bfs(int x, int y) {
		boolean[][] visit = new boolean[50][50];
		Queue<N17086> q = new LinkedList<N17086>();
		q.add(new N17086(x, y, 0));
		while(!q.isEmpty()) {
			N17086 node = q.poll();
			for(int i=0;i<8;i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && !visit[nx][ny]) {
					visit[nx][ny] = true;
					if(graph[nx][ny]) {
						distance[x][y] = node.count+1;
						return;
					}
					q.add(new N17086(nx, ny, node.count+1));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			String[] NM = br.readLine().split(" ");
			n = Integer.parseInt(NM[0]);
			m = Integer.parseInt(NM[1]);
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						graph[i][j] = true;
					}
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			// 0을 만나면 최초로 상어 만날때까지 bfs 진행
			// 당시 count 값을 distance에 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(!graph[i][j]) {
						bfs(i, j);
					}
				}
			}
			int max = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(graph[i][j]) continue;
					max = Math.max(max, distance[i][j]);
				}
			}
			System.out.println(max);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}