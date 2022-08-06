package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon2606 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int V;
	static int E;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean visit[];
	static int count = 0;
	
	public static void dfs(int v) {
		for(int nv : graph.get(v)) {
			if(!visit[nv]) {
				visit[nv] = true;
				dfs(nv);
				count++;
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			V = Integer.parseInt(br.readLine());
			E = Integer.parseInt(br.readLine());
			visit = new boolean[V+1];
			for(int i=0;i<V+1;i++) {
				graph.add(new ArrayList<Integer>());
			}
			for(int i=0;i<E;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph.get(start).add(end);
				graph.get(end).add(start);
			}
			visit[1] = true;
			dfs(1);
			System.out.println(count);
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
