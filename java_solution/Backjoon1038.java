package java_solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Backjoon1038 {
	static int n;
	static ArrayList<Long> table = new ArrayList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final long MAX_NUM = 9876543210L;
	
	// 감소하는 수를 배열에 담는 함수
	// 9876543210 까지의 모든 감소하는 수를 배열에 저장한다.
	public static void decreaseNum(long range, long num) {
		if(num > MAX_NUM) return;
		table.add(num);
		for(int i=0;i<range;i++) {
			long nextnum = num*10+i;
			long nrange = nextnum%10;
			decreaseNum(nrange, nextnum);
		}
	}
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			// 1~9 초깃값으로 작은 수 생성
			for(int i=0;i<10;i++) {
				decreaseNum(i, i);
			}
			Collections.sort(table);
			// n이 table보다 크다면 생성 불가능한 감소하는 수이다.
			if(n>table.size()-1) {System.out.println(-1);}
			else {System.out.println(table.get(n));}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}