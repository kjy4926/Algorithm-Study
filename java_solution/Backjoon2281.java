package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon2281 {
	static int n;
	static int m;
	static int[] nums;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// max + 1 고려하여 길이 인덱스는 최대 1002로 설정
	static int[][] dp = new int[1001][1002]; // [0] = 현재 쓸 이름 idx, [1] = 해당 줄에 쓰인 글자 수
	
	public static int solution(int idx, int len) {
		if(idx >= n) return 0;
		if(dp[idx][len] != -1) return dp[idx][len];
		// 다음 줄에 쓰는 경우
		dp[idx][len] = (m-len+1)*(m-len+1) + solution(idx+1, nums[idx]+1);
		// 이번 줄에 붙여 쓰는 경우
		if(len+nums[idx] <= m) {
			dp[idx][len] = Math.min(dp[idx][len], solution(idx+1, len+nums[idx]+1));
		}
		return dp[idx][len];
	}
	
	public static void main(String[] args) {	
		try {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			nums = new int[n];
			for(int i=0;i<n;i++) {
				nums[i] = Integer.parseInt(br.readLine());
			}
			for(int i=0;i<1001;i++) {
				Arrays.fill(dp[i], -1);
			}
			System.out.println(solution(0, 0));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}