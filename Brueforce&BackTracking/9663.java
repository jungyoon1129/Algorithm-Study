import java.util.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static int n;
    
    static boolean isused1[] = new boolean[15];
    static boolean isused2[] = new boolean[15*8*2-1];
    static boolean isused3[] = new boolean[15*8*2-1];
    
    static int count=0;
   
    
    public static void solve(int i){
        if(i == n ){
            count++;
            return;
        }    
       
            for(int j = 0; j < n; j++){
                if(isused1[j])  continue;
                if(isused2[i+j]) continue;
                if(isused3[n-1+i-j]) continue;
                isused1[j]=true;
                isused2[i+j] = true;
                isused3[n-1+i-j]=true;
                solve(i+1);
                isused1[j]=false;
                isused2[i+j] = false;
                isused3[n-1+i-j]=false;
            }
            
        
    }
    public static void main(String args[]){
        n = sc.nextInt();
        
        solve(0);
        System.out.println(count);
    }
}