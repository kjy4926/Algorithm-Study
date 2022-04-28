package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Process implements Comparable<Process>{
	private int key;
	private int value;
	
	public Process(int k, int v) {
		this.key = k;
		this.value = v;
	}
	
	public int getKey() {return this.key;}
	public int getValue() {return this.value;}
	
	@Override
	public int compareTo(Process P) {
		if(this.value > P.getValue()) return 1;
		else if(this.value == P.getValue()) return 0;
		else return -1;
	}
}

public class Backjoon1700 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PriorityQueue<Process> maxHeap = new PriorityQueue<Process>(Collections.reverseOrder()); // 현재 사용중인 프로세스의 다음 index 저장하는 heap
	static HashMap<Integer, ArrayList<Integer>> schedule = new HashMap<>(); // key = 번호 / value = index -> 사용 스케쥴 표
	static ArrayList<Integer> use = new ArrayList<>(); // 사용중인 제품 번호
	
	public static void main(String[] args) {
		int n = 0; // 멀티탭 구멍 수
		int k = 0; // 전기 용품 사용 횟수
		int count = 0;
		int answer = 0;
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());			
			
			String[] sequence = br.readLine().split(" ");
			// HashMap init
			for(int i=0; i<k; i++) {
				int key = Integer.parseInt(sequence[i]);
				if(schedule.containsKey(key)) {
					schedule.get(key).add(i);
				}
				else {
					schedule.put(key, new ArrayList<Integer>());
					schedule.get(key).add(i);
				}
			}
			for(int i=0; i<k; i++) {
				int key = Integer.parseInt(sequence[i]);
				// 콘센트가 비었다면
				if(count < n) {
					if(!use.contains(key)) {
						use.add(key);
						count++;
					}
				}
				// 콘센트가 꽉찼다면
				else {
					if(!use.contains(key)) {
						// 현재 사용중인 Process 중 가장 나중에 사용 될 Process 제거
						Process item = maxHeap.poll();
						while(maxHeap.size()>0 && !use.contains(item.getKey())){
							item = maxHeap.poll();
						}
						// 삭제 및 use에 key 추가
						use.remove(Integer.valueOf(item.getKey()));
						use.add(key);
						answer += 1;
					}
				}
				// 사용한 스케쥴 제거
				schedule.get(key).remove(0);
				// 만약 스케쥴이 비었다면 다음 순번은 없으므로 value를 매우 큰 값으로 heap에 입력
				if(schedule.get(key).size() == 0) {
					maxHeap.add(new Process(key, Integer.MAX_VALUE));
				}
				// 비어있지 않다면 다음 스케쥴 번호를 value로 heap에 입력
				else {
					maxHeap.add(new Process(key, schedule.get(key).get(0)));
				}
			}
			System.out.println(answer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


// Algorithm -> Priority Queue 사용
// 최초 사용 순서를 1바퀴 탐색하며 Map에 idx 저장
// 사용중이 될 시(콘센트에 꽂힐 때) heap에 해당 key와 다음 사용 idx를 배열로 입력
// 만약 다음 사용 순서가 없을 경우 infinite 입력
// MaxHeap에서 root에 해당하는 key를 가진 값을 제거 후 다음 순서 input