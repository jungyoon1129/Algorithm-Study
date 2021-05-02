import java.util.*;

public class Solution5 {
	public static void main(String args[]) {
		int []stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		int ans = solution(stones, k);
		System.out.println(ans);
	}
	public static int solution(int[] stones, int k) {
		int max =0,min=0;
		for(int i: stones) {
			max = Math.max(i, max);
			min = Math.min(min, i);
		}
		return binarySearch(stones,k,max,min);
    }
	public static boolean cancross(int stones[], int k, int mid) {
		int cnt = 0;
		for(int i: stones) {
			if(i-mid<0) {
				cnt++;
			}
			else
				cnt = 0;
			if(cnt >= k)	return false;
		}
		return true;
		
	}
	
	public static int binarySearch(int[] stones,int k,int hi, int lo) {
		if(lo==hi)	return lo;
		
		while(hi > lo) {
			int mid = lo +(hi-lo)/2;
			if(cancross(stones,k,mid)) {
				lo = mid+1;
			}
			else
				hi = mid;
		}
		return lo-1;
	}
}
