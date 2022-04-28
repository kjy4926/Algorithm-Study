package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N13549{
	int pos;
	int count;
	int time;
	N13549(int pos, int count, int time){
		this.pos = pos;
		this.count = count;
		this.time = time;
	}
}

public class Backjoon13549 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int k;
	static int time = Integer.MAX_VALUE;
	static int count = Integer.MAX_VALUE;
	static final int MAX = 100001;
	static boolean[] visit = new boolean[1000001];
	
	public static void bfs() {
		Queue<N13549> q = new LinkedList<N13549>();
		q.add(new N13549(n, 0, 0));
		visit[n] = true;
		while(!q.isEmpty()) {
			N13549 node = q.poll();
			visit[node.pos] = true;
			if(node.count > count) {
				break;
			}
			if(node.pos == k) {
				if(node.count < count) {
					count = node.count;
				}
				time = Math.min(time, node.time);
			}
			int n1 = node.pos+1; // 앞
			int n2 = node.pos-1; // 뒤
			int tel = node.pos*2; // 텔레포트
			if(n1>=0 && n1 < MAX && !visit[n1]) {
				q.add(new N13549(n1, node.count+1, node.time+1));
			}
			if(n2>=0 && !visit[n2]) {
				q.add(new N13549(n2, node.count+1, node.time+1));
			}
			if(tel>0 && tel < MAX && !visit[tel]) {
				q.add(new N13549(tel, node.count+1, node.time));
			}
		}
		System.out.println(time);
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
