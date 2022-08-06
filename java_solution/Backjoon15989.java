package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Backjoon15989 {
	static int n;
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp = new int[10001][4];
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++) {
				nums.add(Integer.parseInt(br.readLine()));
			}
			dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
			for(int i=4;i<10001;i++) {
				dp[i][1] = dp[i-1][1]; // 식의 마지막이 +1인 경우
				dp[i][2] = dp[i-2][1] + dp[i-2][2]; // +2인 경우
				dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3]; // +3인 경우
			}
			for(int i=0;i<nums.size();i++) {
				int num = nums.get(i);
				System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// 점화식 설명
// https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-15989-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-4-Java