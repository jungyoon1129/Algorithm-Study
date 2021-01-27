import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int back = arr[n-1];
		int cnt = 0;
		
		for(int i = arr.length-2; i>=0; i--) {
			if(arr[i] < back) {
				back = arr[i];
			}
			else {
				cnt += arr[i] - back +1;
				back = back - 1;
			}
		}
		System.out.println(cnt);
	}

}
