import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int allMax_count = 0;
		int localMax = 0;
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] > localMax) {
				localMax = arr[i];
				allMax_count = Math.max(allMax_count, cnt);
				cnt = 0;
			}
			else cnt++;
		}
		allMax_count = Math.max(allMax_count, cnt);
		System.out.println(allMax_count);
	}
}
