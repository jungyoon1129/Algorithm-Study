import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        long arr1[] = new long[n]; 
        
       
        for(int i = 0 ; i < n; i++)
            arr1[i] = sc.nextLong();
         Arrays.sort(arr1);
        
        int mid;
        long temp;
        int m = sc.nextInt();
        int sucess[] = new int[m];
       
        
       
        
            for (int i = 0; i < m; i++){
                int high = n-1;
                int low = 0;
                temp=sc.nextLong(); 
                
                while(high >= low){
                    mid= (high+low)/2;
                    if(arr1[mid] == temp){
                        sucess[i]=1;
                        break;
                    }
                    else if(arr1[mid] < temp){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
        
        
        for (int i : sucess) System.out.println(i);

    }
}