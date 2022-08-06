package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N12851{
	int pos;
	int count;
	N12851(int pos, int count){
		this.pos = pos;
		this.count = count;
	}
}

public class Backjoon12851 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int k;
	static int time = Integer.MAX_VALUE;
	static int num;
	static final int MAX = 100001;
	static boolean[] visit = new boolean[1000001];
	
	public static void bfs() {
		Queue<N12851> q = new LinkedList<N12851>();
		q.add(new N12851(n, 0));
		visit[n] = true;
		while(!q.isEmpty()) {
			N12851 node = q.poll();
			visit[node.pos] = true;
			if(node.count > time) {
				break;
			}
			if(node.pos == k) {
				if(time > node.count) {
					time = node.count;
					num = 0;
				}
				num++;
				continue;
			}
			int n1 = node.pos+1; // 앞
			int n2 = node.pos-1; // 뒤
			int tel = node.pos*2; // 텔레포트
			if(n1>=0 && n1 < MAX && !visit[n1]) {
				q.add(new N12851(n1, node.count+1));
			}
			if(n2>=0 && !visit[n2]) {
				q.add(new N12851(n2, node.count+1));
			}
			if(tel>0 && tel < MAX && !visit[tel]) {
				q.add(new N12851(tel, node.count+1));
			}
		}
		System.out.println(time);
		System.out.println(num);
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