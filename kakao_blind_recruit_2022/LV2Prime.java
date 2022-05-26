package kakao_blind_recruit_2022;

public class LV2Prime {
	public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n, k);
        String[] split_s = s.split("0+");
        
        for(String str : split_s) {
        	boolean flag = true;
        	Long num = Long.parseLong(str);
        	if(num < 2) continue;
        	for(long i=2;i<=Math.sqrt(num);i++) {
        		if(num%i==0) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) answer++;
        }
        return answer;
    }
}