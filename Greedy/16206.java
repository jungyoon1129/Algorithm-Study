import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Integer arr[] = new Integer[n];
		for(int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		
		
		
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if(a%10 == 0) {
					if(b%10 == 0)	return a-b;
					else {
						return -1;
					}
				}
				else {
					if(b%10 == 0)	return 1;
					else {
						return a- b;
					}
				}
			}
		});
		int cnt = 0;
		int canDivide;
		
		for(int i = 0; i < arr.length && m != 0; i++) {
			if(arr[i] == 10)	cnt++;
			else if(arr[i] < 10) continue;
			else {
				if(arr[i] %10 == 0) canDivide = arr[i] / 10 -1 ;
				else  canDivide = arr[i] / 10;
				
				if(m >= canDivide) {
					
					if(arr[i] %10 == 0) {
						m -= canDivide;
						cnt += canDivide+1;
					}
                    else {
                    	m -= canDivide;
                    	cnt += canDivide;
                    }
				}
				else {
					cnt += m;
					m = 0;
				}
			}
		}
		System.out.println(cnt);
	}

}
