package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1495 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int s;
	static int p;
	static int m;
	static int[] dp = new int[1001];
	
	public static void main(String[] args) {
		try {
			Arrays.fill(dp, -1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			dp[s] = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=1;i<n+1;i++) {
				list.clear();
				int v = Integer.parseInt(st2.nextToken());
				for(int j=0;j<m+1;j++) {
					if(dp[j] == i-1) {
						int plus = j + v;
						int minus = j - v;
						if(plus >= 0 && plus <= m) list.add(plus);
						if(minus >= 0 && minus <= m) list.add(minus);
					}
				}
				for(int k : list) {
					dp[k] = i;
				}
			}
			int max = -1;
			for(int i=0;i<m+1;i++) {
				if(dp[i] == n) {
					max = i;
				}
			}
			System.out.println(max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// 해당 문제는 DFS 혹은 BFS를 통해 풀게되면 2^N의 복잡도를 가진다.
// 따라서 무조건 시간초과 혹은 메모리초과가 발생한다.
// 이를 해결하기 위해 Volume dp를 만들었으며
// 해당 배열에 i번째 연주가 가능함을 담았다.
// 최종적으로 입력된 n과 같은 값을 가지는 dp 배열 값 중 최댓값을 출력한다.
// 이렬 경우 곡은 최대 50곡 M은 최대 1000이므로 최대 약 5만번의 연산만이 수행된다.