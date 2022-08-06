package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon10422 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int t;
	static int[] nums;
	static long[] dp = new long[5001];
	
	public static void main(String[] args) {
		try {
			t = Integer.parseInt(br.readLine());
			nums = new int[t];
			dp[0] = 1;
			dp[2] = 1;
			// dp 배열 초기화
			for(int i=2;i<4999;i+=2) {
				for(int j=0;j<=i;j+=2) {
					dp[i+2] += dp[j]*dp[i-j];
					dp[i+2] %= 1000000007L;
				}
			}
			for(int i=0;i<t;i++) {
				nums[i] = Integer.parseInt(br.readLine());
			}
			for(int i=0;i<t;i++) {
				System.out.println(dp[nums[i]]);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// https://devowen.com/263 -> 점화식 참고하기!