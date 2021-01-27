import java.util.*;

public class Main{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long arr[] = new long[1000001];
        int temp;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        
        for(int i =4; i <arr.length; i++){
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
            arr[i]%=1000000009;
        }
        
        for(int i = 0; i < t; i++){
            temp = sc.nextInt();  
            System.out.println(arr[temp]);
        }
     }
}