import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int sum = 0;
        
        for(int i = 1; i < n ;i++){
            int temp = i;
            sum += temp;
            while(temp > 0){
                int res = temp % 10;
                sum+=res;
                temp /= 10;
            }
            if(sum == n){
                ans = i;
                break;
            }
            else
                sum = 0;
        }
        System.out.println(ans);
    }
}