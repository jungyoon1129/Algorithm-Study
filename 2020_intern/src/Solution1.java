import java.util.*;
class info{
	int r,c;
	public info(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		String ans = solution(numbers, hand);
		System.out.println(ans);
	}
	
	 public static String solution(int[] numbers, String hand) {
		 StringBuilder sb = new StringBuilder();
		 int row1=3,col1=0;
		 int row2=3, col2=2;
		 int dist1 =0, dist2 = 0;
		 
		 for(int i = 0; i < numbers.length; i++) {
			 switch(numbers[i]) {
			 case 1:
			 case 4:
			 case 7:
				 row1 = (numbers[i]-1)/3;
				 col1 = 0;
				 sb.append('L');
				 break;
			 case 3:
			 case 6:
			 case 9:
				 row2 = (numbers[i]-1)/3;
				 col2 = 2;
				 sb.append('R');
				 break;
			 case 0:
				 numbers[i] = 10;
			 case 2:
			 case 5:
			 case 8:			 
				 dist1 = Math.abs(row1-(numbers[i]-1)/3) + Math.abs(col1-1);
				 dist2 = Math.abs(row2-(numbers[i]-1)/3) + Math.abs(col2-1);
				 if(dist1 < dist2) {
					 //왼쪽 손이 더 가까운경우
					 row1 = (numbers[i]-1)/3;
					 col1 = 1;
					 sb.append('L');
				 }
				 else if(dist1 > dist2) {
					 row2 = (numbers[i]-1)/3;
					 col2 = 1;
					 sb.append('R');
				 }
				 else {
					 if(hand.equals("left")) {
						 row1 = (numbers[i]-1)/3;
						 col1 = 1;
						 sb.append('L');
					 }
					 else {
						 row2 = (numbers[i]-1)/3;
						 col2 = 1;
						 sb.append('R');
					 }
				 }
				 break;
			 }
		 }
		 
		 return sb.toString();
	 }
	
}
