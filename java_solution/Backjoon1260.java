package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1260 {
	static boolean dfsVisit[];
	static boolean bfsVisit[];
	static int V;
	static int E;
	static int S;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static String dfsRoute = "";
	static String bfsRoute = "";
	
	public static void dfs(int idx) {
		for(int i : graph.get(idx)) {
			if(dfsVisit[i] != true) {
				dfsVisit[i] = true;
				dfsRoute += Integer.toString(i) + " ";
				dfs(i);
			}
		}
	}
	public static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(idx);
		while(!q.isEmpty()) {
			int now = q.poll();
			bfsRoute += Integer.toString(now) + " ";
			for(int i : graph.get(now)) {
				if(bfsVisit[i] != true) {
					bfsVisit[i] = true;
					q.add(i);
				}
			}
		}
	}
	public static void main(String[] args) {	
		try {
			String[] VES = br.readLine().split(" ");
			V = Integer.parseInt(VES[0]);
			E = Integer.parseInt(VES[1]);
			S = Integer.parseInt(VES[2]);
			dfsVisit = new boolean[V+1];
			bfsVisit = new boolean[V+1];
			
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
			for(int i=0;i<V+1;i++) {
				Collections.sort(graph.get(i));
			}
			dfsVisit[S] = true;
			bfsVisit[S] = true;
			dfsRoute += Integer.toString(S) + " ";
			dfs(S);
			bfs(S);
			System.out.println(dfsRoute.trim());
			System.out.println(bfsRoute.trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}