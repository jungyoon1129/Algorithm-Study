import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[][] = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int arr1[], int arr2[]) {
				if(arr1[1] == arr2[1]) {
					return arr1[0] - arr2[0];
				}
				else
					return arr1[1] - arr2[1];
			}
		});
		
		int lastTime = 0;
		int cnt = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] < lastTime) continue;
			cnt++;
			lastTime = arr[i][1];
			
		}
		
		System.out.println(cnt);
	}

}

