package java_solution;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

class Walls implements Comparable<Walls> {
	private int idx;
	private int value;
	
	public Walls(int i, int v) {
		this.idx = i;
		this.value = v;
	}
	public int getIdx() {
		return this.idx;
	}
	public int getValue() {
		return this.value;
	}
	
	@Override
	public int compareTo(Walls w) {
		if(this.value > w.getValue()) return 1;
		else if(this.value == w.getValue()) return 0;
		else return -1;
	}
}

public class Backjoon14719 {
	public static Scanner scan = new Scanner(System.in);
	public static int h;
	public static int w;
	public static ArrayList<Walls> wall = new ArrayList<>();
	
	public static void main(String[] args) {
		h = scan.nextInt();
		w = scan.nextInt();
		ArrayList<Walls> copy_list = new ArrayList<>();
		int left = -1;
		int right = -1;
		int answer = 0;
		
		for(int i=0; i<w; i++) {
			wall.add(new Walls(i, scan.nextInt()));
		}
		
		copy_list.addAll(wall); // Deep Copy
		copy_list.sort(Comparator.reverseOrder()); // 복사한 리스트를 value 기준 내림차순 정렬
		// 가장 큰 값으로 초기화
		left = copy_list.get(0).getIdx();
		right = copy_list.get(0).getIdx();
		int idx = 1;
		
		while((left > 0 || right < w-1) && idx < wall.size()) {
			int next_max_idx = copy_list.get(idx).getIdx();
			if(next_max_idx < left) {
				for(int i=next_max_idx+1;i<left;i++) {
					answer += (copy_list.get(idx).getValue()-wall.get(i).getValue());
				}
				left = next_max_idx;
			}
			else if(next_max_idx > right){
				for(int i=right+1; i<next_max_idx;i++) {
					answer += (copy_list.get(idx).getValue()-wall.get(i).getValue());
				}
				right = next_max_idx;
			}
			idx++;
		}
		System.out.println(answer);
	}
}

// Algorithm
// 1. 벽의 높이가 높은 순서데로 정렬한다.
// 2. 최초 가장 높이가 높은 벽이 기준이된다.
// 3. 기준에서 왼쪽(left) 오른쪽(right)로 구역을 나눈다.
// 4. 나누는 기준은 다음으로 높은 기둥이다.
// 5. 나눠진 구역의 물의 양을 계산한다.
// 6. left right를 해당 기둥으로 기동시킨다.
// 7. left right가 범위를 벗어날 때까지 이를 반복한다.