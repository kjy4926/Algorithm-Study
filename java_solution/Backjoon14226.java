package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class N14226{
	int emo;
	int buffer;
	int count;
	
	N14226(int emo, int buffer, int count){
		this.emo = emo;
		this.buffer = buffer;
		this.count = count;
	}
}

public class Backjoon14226 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int s;
	static boolean[][] visit = new boolean[1001][1001]; // visit[emo][buffer]
	
	public static void bfs() {
		Queue<N14226> q = new LinkedList<N14226>();
		q.add(new N14226(1, 0, 0));
		visit[1][0] = true;
		while(!q.isEmpty()) {
			N14226 node = q.poll();
			if(node.emo == s) {
				System.out.println(node.count);
				break;
			}
			
			int nbuffer = node.emo; // 클립보드 저장될 값
			int nemo = node.emo + node.buffer; // 붙여넣기할 값
			int demo = node.emo-1; // 삭제한 값
			
			// 버퍼 갱신
			if(nbuffer > 0 && nbuffer < 1001 && !visit[node.emo][nbuffer]) {
				visit[node.emo][nbuffer] = true;
				q.add(new N14226(node.emo, nbuffer, node.count+1));
			}
			if(nemo>0 && nemo < 1001 && !visit[nemo][node.buffer]) {
				visit[nemo][node.buffer] = true;
				q.add(new N14226(nemo, node.buffer, node.count+1));
			}
			if(demo > 0 && !visit[demo][node.buffer]) {
				visit[demo][node.buffer] = true;
				q.add(new N14226(demo, node.buffer, node.count+1));
			}
		}
	}
	public static void main(String[] args) {
		try {
			s = Integer.parseInt(br.readLine());
			bfs();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
