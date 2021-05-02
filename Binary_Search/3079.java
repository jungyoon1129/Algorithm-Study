import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int arr[] = new int[n];
        
        for(int i =0;i<n; i++){
            arr[i] = sc.nextInt();
        }
        long high =(long) Math.pow(10,18);
        long low= 1;
        long mid;
        long ans=0;
        long sum=0;
        while(high >= low){
            mid = (high+low)/2;
            sum=0;
            for(int i =0; i< n; i++){
                sum+=mid/arr[i];
                if(sum >= m)    break;
            }
            if(sum < m){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        
        System.out.println(ans);
            
    }
}