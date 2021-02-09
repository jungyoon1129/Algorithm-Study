import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int arr[][] = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]+sc.nextInt();
            }
        }
        
        for(int i = 0; i <m; i++){
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b2 = sc.nextInt();
            System.out.println(arr[a2][b2] - arr[a1-1][b2] - arr[a2][b1-1] + arr[a1-1][b1-1]);
        }
    }
}