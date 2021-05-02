import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        
        int case1 = 0;
        int case2 = 0;
        int ans = 2500;
        
        char arr[][] = new char[a][b];
        for(int i = 0; i < a; i++){
            String str = sc.nextLine();
            for(int j = 0; j < str.length(); j++)
                arr[i][j] = str.charAt(j);
        }
        
        for(int i = 0; i <= a-8; i++){                             
            for(int j = 0; j <= b-8; j++){
                for(int k = i; k < i+8; k++){
                    for(int m = j; m < j+8; m++){
                        if(arr[k][m] == 'W'){
                            if((k+m)% 2 == 0)    case2++;
                            else     case1++;     
                        }
                        else if(arr[k][m] == 'B'){
                            if((m+k)% 2 == 0)    case1++;
                            else     case2++;     
                        }                
                    }
                }
                ans = Math.min(Math.min(ans,case1),case2);
                case1 = 0; case2 = 0;
            }
            
        }
        System.out.println(ans);
    }
}