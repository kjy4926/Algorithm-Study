package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon2493 {
	private static Stack<int[]> stack = new Stack<>();
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int n;
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder result = new StringBuilder();
			for(int i=0;i<n;i++) {
				int h = Integer.parseInt(st.nextToken());
				while(!stack.isEmpty() && stack.peek()[1]<h) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					result.append(0 + " ");
				}else {
					result.append(stack.peek()[0] + " ");
				}
				stack.push(new int[] {i+1, h});
			}
			System.out.println(result.toString());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
