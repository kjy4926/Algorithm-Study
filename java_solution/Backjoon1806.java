package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon1806 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> number = new ArrayList<Integer>();
	static int n = 0;
	static int s = 0;
	static int min = Integer.MAX_VALUE;
	
	public static void twoPointer() {
		int end = 0;
		int sum = 0;
		for(int i=0;i<n;i++) {
			while(sum<s && end<n) {
				sum += number.get(end);
				end++;
			}
			if(sum >= s) {
				min = Math.min(min, end-i);
			}
			sum -= number.get(i);
		}
	}
	public static void main(String[] args) {
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			String[] input = br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				number.add(Integer.parseInt(input[i]));
			}
			twoPointer();
			if(min > n) {
				System.out.println(0);
			}
			else {
				System.out.println(min);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Algorithm -> 투 포인터 알고리즘