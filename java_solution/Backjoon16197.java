package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon16197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map = new int[21][21];
	static int n;
	static int m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<int[]> pos = new ArrayList<int[]>();
	static boolean[][] visit1 = new boolean[22][22];
	static boolean[][] visit2 = new boolean[22][22];
	
	public static void bfs() {
		int[] start = {pos.get(0)[0], pos.get(0)[1], pos.get(1)[0], pos.get(1)[1], 0};
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(start);
		while(!q.isEmpty()) {
			int[] position = q.poll();
			for(int i=0;i<4;i++) {
				int nx1 = position[0]+dx[i];
				int ny1 = position[1]+dy[i];
				int nx2 = position[2]+dx[i];
				int ny2 = position[3]+dy[i];
				int count = position[4];
				
				if(count == 10) {
					System.out.println(-1);
					return;
				}
				// 돌이 하나만 map 위에 올라와있는 경우
				if(((nx1==0 || nx1>n || ny1==0 || ny1>m) && (nx2>0 && nx2<=n && ny2>0 && ny2<=m)) ||
					((nx2==0 || nx2>n || ny2==0 || ny2>m) && (nx1>0 && nx1<=n && ny1>0 && ny1<=m))) {
					System.out.println(count+1);
					return;
				}
				
				if(map[nx1][ny1] == 1) {
					nx1 = position[0];
					ny1 = position[1];
				}
				if(map[nx2][ny2] == 1) {
					nx2 = position[2];
					ny2 = position[3];
				}
				if(nx1>0 && nx1<=n && ny1>0 && ny1<=m &&
					nx2>0 && nx2<=n && ny2>0 && ny2<=m &&
					!(visit1[nx1][ny1] && visit2[nx2][ny2])) {
					q.add(new int[] {nx1, ny1, nx2, ny2, count+1});
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			for(int i=1;i<=n;i++) {
				String str = br.readLine();
				for(int j=1;j<=m;j++) {
					char c = str.charAt(j-1);
					if(c=='#') {
						map[i][j] = 1;
					}
					if(c=='o') {
						pos.add(new int[] {i, j});
					}
				}
			}
			bfs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}