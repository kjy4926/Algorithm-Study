package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N16953 {
	long value;
	int count;
	N16953(long value, int count){
		this.value = value;
		this.count = count;
	}
}

public class Backjoon16953 {
	static long A;
	static long B;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void bfs() {
		Queue<N16953> q = new LinkedList<N16953>();
		q.add(new N16953(A, 1));
		while(!q.isEmpty()) {
			N16953 node = q.poll();
			long next1 = node.value * 2;
			long next2 = node.value*10 + 1;
			if(next1 == B || next2 == B) {
				System.out.println(node.count+1);
				return;
			}
			if(next1 < B) q.add(new N16953(next1, node.count+1));
			if(next2 < B) q.add(new N16953(next2, node.count+1));
		}
		System.out.println(-1);
	}
	
	public static void main(String[] args) {
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			bfs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}