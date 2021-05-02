import java.util.*;
import java.lang.Math;

public class Main{
   
    public static int arr[] = new int[10000000+1];
     public static void main(String []args){
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int temp =1; temp <=n;temp++){
            if(temp <=1)  arr[temp]=0;
             else if(temp<=3)  arr[temp]=1;
             else if(temp%2==0 && temp%3 ==0)
              arr[temp] =  Math.min(arr[temp/2]+1,Math.min(arr[temp/3]+1, arr[temp-1]+1));
             else if(temp%3 == 0){
                  arr[temp] = Math.min(arr[temp/3]+1, arr[temp-1]+1);
             }
             else if(temp%2==0){
                  arr[temp] = Math.min(arr[temp/2]+1,arr[temp-1]+1);
             }
             else{
                  arr[temp] = arr[temp-1]+1;
             }
        }
        int ans = arr[n];
        System.out.println(ans);
        
     }
    
}