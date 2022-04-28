package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N16930{
	int x;
	int y;
	int count;
	N16930(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Backjoon16930 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n; // x
	static int m; // y
	static int k; // max_move_distance
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] map = new boolean[1000][1000];
	static int[][] visit = new int[1000][1000];
	static int startx;
	static int starty;
	static int endx;
	static int endy;
	
	public static void bfs() {
		Queue<N16930> q = new LinkedList<N16930>();
		q.add(new N16930(startx, starty, 0));
		visit[startx][starty] = 0;
		while(!q.isEmpty()) {
			N16930 node = q.poll();
			int ncount = node.count+1;
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// 최대 k만큼 이동
				for(int j=0;j<k;j++) {
					if(nx>=0 && nx<n && ny>=0 && ny<m) {
						if(map[nx][ny]) break;
						if(visit[nx][ny]==0) {
							if(nx==endx && ny==endy) {
								System.out.println(ncount);
								return;
							}
							visit[nx][ny] = ncount;
							q.add(new N16930(nx, ny, ncount));
						}
						// 이미 더 짧은 최단 경로가 존재하는 경우이다.
						else if(visit[nx][ny] <= visit[node.x][node.y]) break;
					}
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
		System.out.println(-1);
	}
	
	public static void main(String[] args) {
		try {
			String[] NMK = br.readLine().split(" ");
			n = Integer.parseInt(NMK[0]);
			m = Integer.parseInt(NMK[1]);
			k = Integer.parseInt(NMK[2]);
			// map init
			for(int i=0;i<n;i++) {
				String input = br.readLine();
				for(int j=0;j<m;j++) {
					if(input.charAt(j) == '#') {
						map[i][j] = true;
					}
				}
			}
			// position input
			StringTokenizer pos = new StringTokenizer(br.readLine());
			startx = Integer.parseInt(pos.nextToken())-1;
			starty = Integer.parseInt(pos.nextToken())-1;
			endx = Integer.parseInt(pos.nextToken())-1;
			endy = Integer.parseInt(pos.nextToken())-1;
			
			bfs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}