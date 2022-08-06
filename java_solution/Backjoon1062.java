package java_solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon1062 {
	private static int n = 0;
	private static int k = 0;
	private static int max = 0; // 반환할 최대값
	private static ArrayList<String> words = new ArrayList<>(); // 입력된 문자열
	private static boolean[] visited = new boolean[26];
	public static void dfs(int start, int count) {
		if(count == k) {
			int n=0;
			for(String w:words) {
				boolean flag = true;
				for(int c:w.toCharArray()) {
					if(visited[c-97]!= true) {
						flag = false;
						break;
					}
				}
				if(flag)n++;
			}
			max = Math.max(max, n);
		}
		else {
			for(int i=start;i<26;i++) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(i, count+1);
					visited[i] = false;
				}
			}
		}		
	}
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<visited.length;i++) {
			visited[i] = false;
		}
		try {
			String input = "";
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for(int i=0;i<n;i++) {
				input = br.readLine();
				words.add(input.substring(4,input.length()-4));
			}
			// a c i n t 최소 5개의 알파벳을 알아야한다.
			if(k<5) {
				System.out.println(0);
				return;
			}
			// a c i n t -> true
			visited['a'-'a'] = true;
			visited['c'-'a'] = true;
			visited['i'-'a'] = true;
			visited['n'-'a'] = true;
			visited['t'-'a'] = true;
			// 모든 알파벳을 아는 경우 모든 단어를 알고 있다.
			if(k==26) {
				System.out.println(words.size());
				return;
			}
			dfs(0, 5);
			System.out.println(max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

// Algorithm
// 1. 5보다 작으면 0 리턴(anta tica는 최소 5개의 알파벳)
// 2. k == 26 -> 모든 알파벳을 알고 있으므로 n 리턴
// 3. dfs를 통해 모든 조합 가능한 알파벳 조합으로 순회한 후 max 리턴