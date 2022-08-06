package java_solution;
import java.util.ArrayList;
import java.util.Scanner;

public class Backjoon2504 {
	public static ArrayList<Character> stack = new ArrayList<>();
	public static String input_str;
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int answer = 0;
		int tmp = 1;
		input_str = scan.nextLine();
		char[] items = input_str.toCharArray();
		if(input_str.length() < 2) {
			System.out.println(0);
			return;
		}
		for(int i=0;i<items.length;i++) {
			char c = items[i];
			if(c == '(') {
				stack.add(c);
				tmp*=2;
			}
			if(c == ')') {
				if(stack.isEmpty() || stack.get(stack.size()-1) != '(') {
					System.out.println(0);
					return;
				}
				if(items[i-1] == '(') {
					answer += tmp;
				}
				tmp /= 2;
				stack.remove(stack.size()-1);
			}
			if(c == '[') {
				stack.add(c);
				tmp*=3;
			}
			if(c == ']') {
				if(stack.isEmpty() || stack.get(stack.size()-1) != '[') {
					System.out.println(0);
					return;
				}
				if(items[i-1] == '[') {
					answer += tmp;
				}
				tmp /= 3;
				stack.remove(stack.size()-1);
			}
		}
		if(!stack.isEmpty()) {
			System.out.println(0);
			return;
		}
		System.out.println(answer);
	}
}

// Algorithm -> 스택 응용
// ) or ] 를 만났을 때, 바로 직전(now-1) 인덱스가 ( or [ 라면
// answer 값을 늘려준다.