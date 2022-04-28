package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon2293 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int k;
	static int count = 0;
	static int[] tokens;
	static int[] table;
	
	public static void main(String[] args) {
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			tokens = new int[n];
			table = new int[k+1];
			for(int i=0;i<n;i++) {
				tokens[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(tokens);
			// 최초 테이블 초기화
			table[0] = 1;
			for(int i=0;i<tokens.length;i++) {
				for(int j=tokens[i];j<=k;j++) {
					int idx = j-tokens[i];
					table[j] += table[idx];
				}
			}
			System.out.println(table[k]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Algorithm -> Dynamic Programming
// 점화식 : f(k) = f(k-n) n = 코인