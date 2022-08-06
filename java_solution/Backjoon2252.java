package java_solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon2252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 그래프를 표현하는 2차원 인접 리스트
	static int[] indegree; // 해당 노드를 가리키는 간선 갯수를 담는 배열
	static int n; // 노드 수
	static int m; // 비교 수(간선 수)
	
	public static void topologicalSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<n+1;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int node = q.poll();
			graph.get(0).add(node);
			for(int i=0;i<graph.get(node).size();i++) {
				int next = graph.get(node).get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]); // 노드의 수
			m = Integer.parseInt(s[1]); // 간선의 수
			indegree = new int[n+1];
			// graph 노드 1번부터 표시, 0번에는 결과값을 담을 예정
			for(int i=0;i<n+1;i++) {
				graph.add(new ArrayList<Integer>());
			}
			// 간선을 그래프에 입력
			for(int i=0;i<m;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int src = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				graph.get(src).add(dest);
				indegree[dest] += 1;				
			}
			// 위상 정렬
			topologicalSort();
			// 결과 출력
			for(int i=0;i<graph.get(0).size();i++) {
				System.out.printf("%d ", graph.get(0).get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}

// Algorithm -> 위상 정렬(TopologicalSort)