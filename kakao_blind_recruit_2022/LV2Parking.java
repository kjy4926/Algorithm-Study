package kakao_blind_recruit_2022;

import java.util.HashMap;

public class LV2Parking {
	static HashMap<String, String> park = new HashMap<>();
	static HashMap<String, Integer> cost = new HashMap<>();
	public int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		
		for(String r : records) {
			String[] split = r.split(" ");
			String time = split[0];
			String number = split[1];
			String type = split[2];
			
			if(type.equals("IN")) {
				park.put(number, time);
				cost.put(number, 0);
			}
			// OUT
			else {
				String[] stime = park.get(number).split(":");
			}
		}
		
        return answer;
    }
}
