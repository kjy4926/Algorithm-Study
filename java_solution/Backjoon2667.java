package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Backjoon2667 {
	static boolean[][] visited = new boolean[25][25]; // default == false
	static int[] dx = {-1,1,0,0}; // 상 하 좌 우
	static int[] dy = {0,0,-1,1}; // 상 하 좌 우
	static int n; // x, y 값
	static int apart_count = 0; // 단지 수
	static ArrayList<Integer> nums = new ArrayList<>(); // 단지 인원 수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map = new int[25][25];
	static int count;
	
	static void dfs(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// x, y 가 범위 내의 값이고, 아직 방문하지 않았다면
			if(nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] != true) {
				visited[nx][ny] = true;
				// 해당 노드가 1이라면
				if(map[nx][ny] == 1) {
					count += 1;
					nums.set(apart_count, count);
					dfs(nx, ny);
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			// map 입력
			for(int i=0;i<n;i++) {
				String data = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j] = data.charAt(j)-48;
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					// 방문 x 해당 노드가 1이라면
					if(visited[i][j] != true && map[i][j] == 1) {
						visited[i][j] = true;
						nums.add(1);
						count = 1;
						dfs(i, j);
						apart_count += 1;
					}
				}
			}
			Collections.sort(nums);
			System.out.println(apart_count);
			for(int i=0;i<nums.size();i++) {
				System.out.println(nums.get(i));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Algorithm -> DFS
// 노드를 탐색하며 1을 만날 경우 visited를 true로 변경하고 dfs 진행