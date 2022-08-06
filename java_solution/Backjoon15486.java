package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon15486 {
	static int n;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer[]> schedule = new ArrayList<>();
	static int[] dp;
	static int maxCost = 0;
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int days = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				schedule.add(new Integer[] {days, cost});
			}
			dp = new int[n+1];
			int max = 0;
			for(int i=0;i<n;i++) {
				max = Math.max(max, dp[i]);
				int nday = i + schedule.get(i)[0];
				if(nday > n) continue;
				dp[nday] = Math.max(dp[nday], max+schedule.get(i)[1]);
			}
			Arrays.sort(dp);
			System.out.println(dp[dp.length-1]);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}