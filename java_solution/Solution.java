package java_solution;

public class Solution {
    public static int solution(int n, int m, int[] x_axis, int[] y_axis) {
        int answer = 0;
        int bottom = 0;
        int a = 0; // 세로
        int b = 0; // 가로
        int dimension = 0;
        if(x_axis.length == 0 && y_axis.length == 0) {
        	return n*m;
        }
        else if(x_axis.length == 0) {
        	int maxH = 0;
        	int h = 0;
        	for(int y : y_axis) {
        		maxH = Integer.max(maxH, y-h);
        		h = y;
        	}
        	return maxH*n;
        }
        else if(y_axis.length == 0) {
        	int maxW = 0;
        	int w = 0;
        	for(int x : x_axis) {
        		maxW = Integer.max(maxW, x-w);
        		w = x;
        	}
        	return maxW*m;
        }else {
	        for(int y : y_axis) {
	        	int width = 0;
	        	for(int x : x_axis) {
	        		// 평행선 안쪽 비교
	        		a = y-bottom; // 세로
	        		b = x-width; // 가로
	        		dimension = a*b;
	        		answer = Integer.max(answer, dimension);
	        		width = x;
	        	}
	        	// 마지막 x_aixs 우측영역 넓이
	        	b = n-width;
	        	dimension = a*b;
	    		answer = Integer.max(answer, dimension);
	        	bottom = y;
	        }
	        // 마지막 y_axis 상단영역 넓이
	        int width = 0;
	        a = m-y_axis[y_axis.length-1];
	        for(int x : x_axis) { 
	        	b = x-width; // 가로
	        	dimension = a*b;
	    		answer = Integer.max(answer, dimension);
	    		width = x;
	        }
	        // 마지막 영역 너비
	        b = n-width;
	        answer = Integer.max(answer, a*b);
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int n = 3;
    	int m = 4;
    	int[] x_axis = {2};
    	int[] y_axis = {1,2};
    	System.out.println(solution(n, m, x_axis, y_axis));
	}
}
