package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon2294 {
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
			Arrays.fill(table, 100001);
			table[0] = 0;
			for(int i=0;i<n;i++) {
				for(int j=tokens[i];j<=k;j++) {
					int idx = j-tokens[i];
					table[j] = Math.min(table[j], table[idx]+1);
				}
			}
			if(table[k] == 100001) System.out.println(-1);
			else System.out.println(table[k]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Algorithm -> DP
//n원의 동전으로 n원을 만드는 경우는 0원을 만드는 경우 + 1
// 점화식 f(k) = min(f(k), f(k-n)+1) n = 코인