package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LV1Report {
	static HashSet<String> reportSet = new HashSet<>();
	static HashMap<String, ArrayList<String>> reportTable = new HashMap<>();
	static HashMap<String, Integer> result = new HashMap<>();
	
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        for(String id : id_list) {
        	reportTable.put(id, new ArrayList<String>());
        	result.put(id, 0);
        }
        
        for(String s : report) {
        	reportSet.add(s);
        }
        Iterator<String> iter = reportSet.iterator();
        while(iter.hasNext()) {
        	String[] spl = iter.next().split(" ");
        	String src = spl[0];
        	String dest = spl[1];
        	
        	reportTable.get(dest).add(src);
        }
        for(ArrayList<String> lis : reportTable.values()) {
        	if(lis.size()<k) continue;
        	for(int i=0;i<lis.size();i++) {
        		String id = lis.get(i);
        		result.put(id, result.get(id)+1);
        	}
        }
        for(int i=0;i<answer.length;i++) {
        	answer[i] = result.get(id_list[i]);
        }
        return answer;
    }
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int[] r = solution(id_list, report, 2);
		for(int n : r) {
			System.out.println(n);
		}
	}
}
