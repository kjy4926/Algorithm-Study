package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 목적지, 비용을 저장하는 Node
class Node implements Comparable<Node>{
	private int dest;
	private int cost;
	
	Node(int d, int c){
		this.dest = d;
		this.cost = c;
	}
	
	public int getDest() {
		return this.dest;
	}
	public int getCost() {
		return this.cost;
	}

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, node.cost);
	}
}

public class Backjoon1916 {
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] minimum; // 방문 노드 표
	static int V; // 도시 수
	static int E; // 버스 수
	static int source;
	static int dest;
	
	public static void main(String[] args) {
		try {
			V = Integer.parseInt(br.readLine()); // 점의 수
			E = Integer.parseInt(br.readLine()); // 간선의 수
			minimum = new int[V];
			// 그래프 초기화
			for(int i=0;i<V;i++) {
				graph.add(new ArrayList<Node>());
			}
			// 그래프 입력
			for(int i=0;i<E;i++) {
				// 노드가 1부터 존재하므로 s, d값을 -1
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1; // start
				int d = Integer.parseInt(st.nextToken())-1; // dest
				int cost = Integer.parseInt(st.nextToken());
				graph.get(s).add(new Node(d, cost));
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 마지막 줄 출발, 도착지 입력받기 -> 동일한 이유로 -1
			source = Integer.parseInt(st.nextToken())-1;
			dest = Integer.parseInt(st.nextToken())-1;
			// 시작지로의 거리는 0 입력
			pq.add(new Node(source, 0));
			minimum[source] = 0;
			// 각 경로까지 길이 초기화
			Arrays.fill(minimum, Integer.MAX_VALUE);
			// 다익스트라 알고리즘
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				int d = n.getDest(); // 목적지
				int c = n.getCost(); // 비용
				// 이미 최단 경로가 존재하면 다음 노드 확인
				if(minimum[d] < c) {
					continue;
				}
				// 이동한 위치에서 다음 이동 가능한 경로들을 탐색하여 최단거리 갱신 및 큐에 입력
				for(int i=0;i<graph.get(d).size();i++) {
					int next_dest = graph.get(d).get(i).getDest();
					int next_cost = c + graph.get(d).get(i).getCost();
					if(next_cost < minimum[next_dest]) {
						minimum[next_dest] = next_cost;
						pq.add(new Node(next_dest, next_cost));
					}
				}
			}
			System.out.println(minimum[dest]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Algorithm -> 다익스트라 알고리즘