package kakao_blind_recruit_2022;

public class LV3Building {	
	
	public static int solution(int[][] board, int[][] skill) {
	    int answer = 0;
	    int[][] sumBoard = new int[board.length+2][board[0].length+2];
	    
	    for(int[] s : skill) {
	    	int type = s[0];
	    	int r1 = s[1];
	    	int c1 = s[2];
	    	int r2 = s[3];
	    	int c2 = s[4];
	    	int degree = s[5];
	    	
	    	if(type==1) {
	    		degree = -degree;
	    	}
	    	
	    	sumBoard[r1+1][c1+1] += degree;
	    	sumBoard[r2+2][c1+1] -= degree;
	    	sumBoard[r1+1][c2+2] -= degree;
	    	sumBoard[r2+2][c2+2] += degree;
	    }
	    
	    // 누적합 계산
	    // 1부터 하는 이유는 i-1, j-1 연산이 편하기 위해서
	    for(int i=1;i<sumBoard.length;i++) {
	    	for(int j=1;j<sumBoard.length;j++) {
	    		sumBoard[i][j] = sumBoard[i][j] + sumBoard[i-1][j] + sumBoard[i][j-1] - sumBoard[i-1][j-1];
	    	}
	    }
	    
	    // 기본 board와 합연산
	    for(int i=0;i<board.length;i++) {
	    	for(int j=0;j<board[0].length;j++) {
	    		if(board[i][j]+sumBoard[i+1][j+1]>0) {
	    			answer+=1;
	    		}
	    	}
	    }
	    
	    return answer;
	}
	public static void main(String[] args) {
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		System.out.println(solution(board, skill));
	}
}

/*
1. 누적합을 사용하는 문제
2. dp[i][j] = A[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] -> 2차원 배열 누적합 점화식
3. https://yjyoon-dev.github.io/kakao/2022/01/18/kakao-2022-blind-06/ 참고 URL
알고리즘 공부 더 하자!
*/