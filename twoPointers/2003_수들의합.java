import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int count = 0; 
        
        for(int i = 0; i < n; i++)
            arr[i] =  sc.nextInt();
        
        int a = 0; int b= 0;
        int sum=0;
        
        while(true){
            if(sum >= m) sum -= arr[a++];
            else{
                if(b == arr.length) break;
                else
                     sum += arr[b++];
               
            }
             if(sum==m) count++;
        }
        
        System.out.println(count);
        
    }
}