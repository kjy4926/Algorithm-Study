package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class N13913{
	int pos;
	int count;
	N13913 prev;
	N13913(int pos, int count, N13913 prev){
		this.pos = pos;
		this.count = count;
		this.prev = prev;
	}
}

public class Backjoon13913 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int k;
	static int time = Integer.MAX_VALUE;
	static final int MAX = 100001;
	static boolean[] visit = new boolean[1000001];
	static N13913 enode;// end node
	static Stack<Integer> route = new Stack<>(); // 경로 스택
	
	public static void bfs() {
		Queue<N13913> q = new LinkedList<N13913>();
		q.add(new N13913(n, 0, null));
		visit[n] = true;
		while(!q.isEmpty()) {
			N13913 node = q.poll();
			if(node.pos == k) {
				time = node.count;
				enode = node;
				break;
			}
			int n1 = node.pos+1; // 앞
			int n2 = node.pos-1; // 뒤
			int tel = node.pos*2; // 텔레포트
			if(n1>=0 && n1 < MAX && !visit[n1]) {
				q.add(new N13913(n1, node.count+1, node));
				visit[n1] = true;
			}
			if(n2>=0 && !visit[n2]) {
				q.add(new N13913(n2, node.count+1, node));
				visit[n2] = true;
			}
			if(tel>0 && tel < MAX && !visit[tel]) {
				q.add(new N13913(tel, node.count+1, node));
				visit[tel] = true;
			}
		}
		System.out.println(time);
		while(enode != null) {
			route.push(enode.pos);
			enode = enode.prev;
		}
		while(!route.isEmpty())System.out.print(route.pop() + " ");
	}
	
	public static void main(String[] args) {
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			bfs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}