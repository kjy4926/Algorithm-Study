package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon16916 {
	static String origin;
	static String sub;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] table;
	// 전처리 테이블 작성
	public static void makeTable(String p) {
		int len = p.length();
		table = new int[len];
		int i = 0;
		
		for(int j=1;j<len;j++) {
			while(i>0 && p.charAt(i) != p.charAt(j)) {
				i = table[i-1];
			}
			if(p.charAt(i) == p.charAt(j)) {
				i++;
				table[j] = i;
			}
		}
	}
	// KMP 알고리즘
	public static boolean kmp(String str, String p) {
		int j = 0;
		for(int i=0;i<str.length();i++) {
			while(j>0 && str.charAt(i) != p.charAt(j)) {
				j = table[j-1];
			}
			if(str.charAt(i) == p.charAt(j)) {
				if(j==p.length()-1) {
					return true;
				}
				else {
					j++;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		try {
			origin = br.readLine();
			sub = br.readLine();
			makeTable(sub);
			System.out.printf("%d", kmp(origin, sub)?1:0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
// Algorithm -> KMP 알고리즘