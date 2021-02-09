import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0; i< n; i++)
            arr[i] = sc.nextInt();
        
        Arrays.sort(arr);
        
        if(arr.length == 1||arr.length == 2) System.out.println("0");
        else{
            int a,b;int count = 0;int temp;
        for(int i =0; i < arr.length; i++){
            int target = arr[i];
            a = 0; b =arr.length-1;
            while(a < b){                               
                temp = arr[a]+arr[b];
                if(temp == target){
                    if(i!= a && i!=b){
                        count++;
                        break;
                    }
                    if(a == i)
                        a++;
                    if(b==i)
                        b--;
                    
                }
                else if(temp < target)    a++;
                else b--;
            }
        }
        System.out.println(count);
        }
        
    }
}