import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[1516];        //15배수 카운트
        int dp1[] = new int[1516];        //1의 개수
        int dp5[] = new int[1516];        //5의 개수
        int combi[][] = new int[1516][1516];    //조합 nCr
        int count1, count5;
        int first;
        
        combination(combi);
        
        if(n%3==0){
            dp[3] = 1;
            dp1[3] = 0;
            dp5[3] = 3;
            first=6;
        }
        else if(n%3 == 1){
            dp[1] = 0;
            dp1[1] = 0;
            dp5[1] = 0;
            dp[4] = 3;
            dp1[4] = 2;
            dp5[4] = 2;
            first=7;
        }
        else{
            dp[2] = 1;
            dp1[2] = 1;
            dp5[2] = 1;
            first = 5;
        }
             
            for(int i = first; i <= n; i+=3){
                dp1[i] = dp1[i-3]+3;
                dp5[i] = dp5[i-3];
                count1 = dp1[i];
                count5 = dp5[i];
                
                while(count1 >= 0){
                    dp[i] = (dp[i] + combi[count1+count5-1][count5-1]) % 1000000007;
                    count1 -= 3;
                    count5 += 3;
                }
            }
            
        
        
        System.out.println(dp[n]);
    }
    
    public static void combination(int combi[][]){
        for(int n = 1 ; n < 1516; n++ ){
            for(int r = 0; r <= n; r++){
                 if(n == r || r == 0) 
			         combi[n][r] = 1; 
		        else 
			         combi[n][r] = (combi[n-1][r-1] + combi[n-1][r])% 1000000007;
            }  
        }
    }
    
    
}