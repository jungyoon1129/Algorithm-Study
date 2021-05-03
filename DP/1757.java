import java.util.*;
import java.lang.Math;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int dp[][][] = new int[10000+5][505][2];
        int arr[] = new int[n+1];
        
        for(int i =1; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < m+1; j++){  
                if(j==0){
                    dp[i][j][0] = Math.max(dp[i-1][j+1][0],Math.max(dp[i-1][j][0],dp[i-1][j+1][1]));
                }
                else if(j==1){
                    dp[i][j][0] = Math.max(dp[i-1][j+1][0],dp[i-1][j+1][1]);
                    dp[i][j][1] =dp[i-1][j-1][0]+arr[i]; 
                }
                else{
                    dp[i][j][0] = Math.max(dp[i-1][j+1][0],dp[i-1][j+1][1]);
                    dp[i][j][1] =dp[i-1][j-1][1]+arr[i]; 
                }
                
                  
            }
        }
        System.out.println(dp[n][0][0]);
    }
}