package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon5557 {
   static int n;
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static ArrayList<Integer> nums = new ArrayList<>();
   static long[][] dp = new long[99][21];
   static long[] dpresult = new long[21];
   
   public static void main(String[] args) {
      try {
         n = Integer.parseInt(br.readLine());
         StringTokenizer st = new StringTokenizer(br.readLine());
         for(int i=0;i<n;i++) {
            nums.add(Integer.parseInt(st.nextToken()));
         }
         dp[0][nums.get(0)] = 1;
         for(int i=1;i<nums.size()-1;i++) {
            int next = nums.get(i);
            for(int j=0;j<=20;j++) {
               int plus = j + next;
               int minus = j - next;
               if(plus>=0 && plus<=20 && dp[i-1][j] != 0) {
                  dp[i][plus] += dp[i-1][j];
               }
               if(minus>=0 && minus<=20 && dp[i-1][j] != 0) {
                  dp[i][minus] += dp[i-1][j];
               }
            }
         }
         System.out.println(dp[n-2][nums.get(nums.size()-1)]);
      } catch (NumberFormatException | IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
}