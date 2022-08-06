package kakao_blind_recruit_2022;

import java.util.ArrayList;
import java.util.Arrays;

public class LV3_sheepWolf {
	private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	private static int[] visited;
	private static int max = 0;
	
	public static int solution(int[] info, int[][] edges) {
		// tree init
		visited = new int[info.length];
		for(int i=0;i<info.length;i++) {
			tree.add(new ArrayList<Integer>());
		}
		for(int[] edge : edges) {
			tree.get(edge[0]).add(edge[1]);
		}
		
		search(0, new ArrayList<Integer>(), 0, 0, info);
		
		return max;
    }
	
	public static void search(int node, ArrayList<Integer> route, int sheep, int dif, int[] info) {
		if(visited[node] != 0) {
			return;
		}
		visited[node] = 1;
		ArrayList<Integer> nextRoute = new ArrayList<Integer>(route);
		for(int i : tree.get(node)) {
			nextRoute.add(i);
		}
		
		if(info[node] == 0) {
			sheep += 1;
			dif += 1;
			max = Integer.max(max, sheep);
		}else {
			dif -= 1;
		}
		
		if(dif >0) {
			for(int i : nextRoute) {
				search(i, nextRoute, sheep, dif, info);
			}
		}
		visited[node] = 0;
	}
	
	public static void main(String[] args) {
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		System.out.println(solution(info, edges));
	}
}

// 완전 탐색 BFS