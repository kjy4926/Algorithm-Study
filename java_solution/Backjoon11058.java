package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon11058 {
	static long[] dp = new long[101];
	static int n;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			for(int i=1;i<101;i++) {
				dp[i] = dp[i-1]+1;
				if(i>6) {
					for(int j=i-5;j<=i-3;j++) {
						dp[i] = Math.max(dp[i], dp[j]*((i-j)-1));
					}
				}
			}
			System.out.println(dp[n]);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
// 초기값을 입력 후 j-5부터 j-3까지 dp[j]*((i-j)-1)를 수행하여
// 최댓값을 dp[i]에 입력한다.
// j-5 ~ j-3인 이유 -> c+a, c+c, c+v 는 3번의 클릭이 필요하며
// 다음 복사 가능한 영역이 범위가 6이기 때문이다.