package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//목적지, 비용을 저장하는 Node
//class Node implements Comparable<Node>{
//	private int dest;
//	private int cost;
//	
//	Node(int d, int c){
//		this.dest = d;
//		this.cost = c;
//	}
//	
//	public int getDest() {
//		return this.dest;
//	}
//	public int getCost() {
//		return this.cost;
//	}
//
//	@Override
//	public int compareTo(Node node) {
//		// TODO Auto-generated method stub
//		return Integer.compare(this.cost, node.cost);
//	}
//}

public class Backjoon1197 {
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static int V;
	static int E;
	static boolean[] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		try {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 점의 수
			E = Integer.parseInt(st.nextToken()); // 간선의 수
			visited = new boolean[V];
			// 그래프 초기화
			for(int i=0;i<V;i++) {
				graph.add(new ArrayList<Node>());
			}
			// 그래프 입력
			for(int i=0;i<E;i++) {
				// 노드가 1부터 존재하므로 s, d값을 -1
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st2.nextToken())-1; // start
				int d = Integer.parseInt(st2.nextToken())-1; // dest
				int cost = Integer.parseInt(st2.nextToken());
				// 쌍방으로 그래프 연결
				graph.get(s).add(new Node(d, cost));
				graph.get(d).add(new Node(s, cost));
			}
			pq.add(new Node(0, 0));
			// Prim 알고리즘
			while(!pq.isEmpty()) {
				Node item = pq.poll();
				int d = item.getDest();
				// 방문 여부 확인
				if(visited[d]) {
					continue;
				}
				visited[item.getDest()] = true;
				answer += item.getCost();
				for(int i=0;i<graph.get(d).size();i++) {
					Node next_node = graph.get(d).get(i);
					// 방문하지 않은 노드라면 큐에 추가
					if(!visited[next_node.getDest()]) {
						pq.add(next_node);
					}
				}
			}
			System.out.println(answer);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Algorithm -> Prim Algorithm
// 크루스칼은 Union-Find를 잘 모르기에 사용안함!