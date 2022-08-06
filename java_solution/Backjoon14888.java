package java_solution;
import java.util.Scanner;
import java.lang.Math;


public class Backjoon14888 {
	public static Scanner scan = new Scanner(System.in);
	public static int n;
	public static int[] numbers;
	public static int[] operations = new int[4];
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public Scanner scan2 = new Scanner(System.in);
	
	public static void main(String[] args) {
		n = scan.nextInt();
		numbers = new int[n+1];
		for(int i=0; i<n; i++) {
			numbers[i] = scan.nextInt();
		}
		for(int i=0; i<4; i++) {
			operations[i] = scan.nextInt();
		}
		dfs(numbers[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int num, int count) {
		if(count == n) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		
		for(int i=0; i<4;i++) {
			if(operations[i] > 0) {
				operations[i]--;
				switch(i) {
				case 0:
					dfs(num + numbers[count], count+1);
					break;
				case 1:
					dfs(num - numbers[count], count+1);
					break;
				case 2:
					dfs(num * numbers[count], count+1);
					break;
				case 3:
					dfs(num / numbers[count], count+1);
					break;
				}
				operations[i]++;
			}
		}
	}
}