import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        long arr[] = new long[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
            //System.out.println(arr[i]);
        }
        
        Arrays.sort(arr);
        
        long high = arr[n-1];
        long low = 1;
        int sum = 0;
        long mid;
        long ans=0;
        
        while(high >= low){
            mid = (high+low)/2;
            sum=0;
            //System.out.println(mid);
            if(mid==0)
                break;
            for(int i =0; i < n; i++){
                sum += arr[i]/mid;
            }
            //System.out.println("sum "+sum);
            if(sum < m){
                high = mid-1;
            }
            else{
                ans = mid;
                // System.out.println(ans);
                low = mid+1;
                //break;
            }
        }
        System.out.println(ans);
    }
}