package kakao_blind_recruit_2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LV3BoardAB {
	private static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	private static int[] dy = {0, 0, -1, 1};
	private static int[][] destroy = new int[6][6];
	private static Map<Integer, Set<String>> winMap = new HashMap<Integer, Set<String>>(); 
	private static int answer = 0;
	
	public static int solution(int[][] board, int[] aloc, int[] bloc) {
		for(int i=0;i<20;i++) {
			winMap.put(i, new HashSet<String>());
		}
		dfs(board, aloc, bloc, true, 0);
		for(int key : winMap.keySet()) {
			if(winMap.get(key).size()==1) {
				answer = key;
				System.out.println(answer);
			}
		}
		System.out.println(answer);
        return answer;
    }
	// turn -> A턴 : true / B턴 : false
	public static void dfs(int[][] board, int[] aloc, int[] bloc, boolean turn, int count) {
		if(aloc[0] == bloc[0] && aloc[1] == bloc[1]) {
			if(turn) {
				winMap.get(count+1).add("A");
			}else {
				winMap.get(count+1).add("B");
			}
			return;
		}
		int moveCount = 0;
		for(int i=0;i<4;i++) {
			int nx;
			int ny;
			if(turn) {
				nx = aloc[0] + dx[i];
				ny = aloc[1] + dy[i];
				if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && destroy[nx][ny]==0 && board[nx][ny]==1) {
					moveCount++;
					destroy[aloc[0]][aloc[1]] = 1;
					dfs(board, new int[] {nx,ny}, bloc, !turn, count+1);
					destroy[aloc[0]][aloc[1]] = 0;
				}
			}else {
				nx = bloc[0] + dx[i];
				ny = bloc[1] + dy[i];
				if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && destroy[nx][ny]==0 && board[nx][ny]==1) {
					moveCount++;
					destroy[bloc[0]][bloc[1]] = 1;
					dfs(board, aloc, new int[] {nx,ny}, !turn, count+1);
					destroy[bloc[0]][bloc[1]] = 0;
				}
			}
		}
		if(moveCount==0) {
			if(turn) {
				winMap.get(count).add("B");
			}else {
				winMap.get(count).add("A");
			}
		}
	}
	public static void main(String[] args) {
		int[][] board = {{1,1,1},{1,0,1},{1,1,1}};
		int[] aloc = {1,0};
		int[] bloc = {1,2};
		solution(board, aloc, bloc);
	}
}
