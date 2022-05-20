package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon2023 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] head = {2,3,5,7}; // 시작 숫자
	static int[] tail = {1,3,5,7,9}; // 뒤에 붙일 숫자
	
	public static void dfs(int num) {
		if(num > Math.pow(10, n-1) && num < Math.pow(10, n)) {
			System.out.println(num);
			return;
		}
		else {
			for(int i=0;i<5;i++) {
				int nnum = num*10+tail[i];
				boolean flag = true;
				for(int j=2;j<=Math.sqrt(nnum);j++) {
					if(nnum%j==0) {
						flag = false;
						break;
					}
				}
				if(flag) dfs(nnum);
			}
		}
	}
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			for(int i=0;i<head.length;i++) {
				dfs(head[i]);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}