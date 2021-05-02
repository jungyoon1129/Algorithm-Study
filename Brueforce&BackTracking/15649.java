import java.util.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int m;
    static boolean isused[] = new boolean[9];
    static int arr[] = new int[9];
    
    public static void printused(){
        for(int i = 0; i < m; i++)
                System.out.print(arr[i] +" ");
        System.out.println();
    }
    
    public static void solve(int count){
        if(count == m ){
            printused();
            return;
        }    
        for(int i = 1; i <= n; i++){
            if(!isused[i]){
                isused[i]=true;
                arr[count] = i;
                solve(count+1);
                isused[i]=false;
            }
            
        }
    }
    public static void main(String args[]){
        n = sc.nextInt();
        m = sc.nextInt();
        
        solve(0);
        
    }
}