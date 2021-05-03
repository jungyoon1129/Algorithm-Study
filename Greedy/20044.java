import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n *= 2;
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int arr2[] = new int[n/2];
		
		for(int i = 0 ; i < arr2.length; i++)
			arr2[i] = arr[i] + arr[arr.length -i-1];
		Arrays.sort(arr2);
		int result = arr2[0];
		
		System.out.println(result);
	}

}
