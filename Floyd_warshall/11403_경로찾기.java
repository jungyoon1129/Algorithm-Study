import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int max = Integer.MAX_VALUE;  
        int n= sc.nextInt();
        int dist[][] = new int[n+1][n+1];               
        int current;
        int next;
        int temp;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                temp = sc.nextInt();
                dist[i][j] = temp;
            }
        }
        
       for(int i = 1; i <= n; i++){
           //i는 경유하는 노드
           
           for(int j = 1; j <= n; j++){
                 
               for(int k = 1; k <=n; k++){
                   if(dist[j][i]==1 && dist[i][k]==1  ){
                      
                        dist[j][k] = 1;
                   }
               }
           }
        }
        
        
       StringBuilder sb = new StringBuilder();
        for(int i =1; i <=n; i++) {
            for(int j =1; j <=n; j++) {
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        
       bw.write(sb.toString());
        bw.flush();
        bw.close();
        
        
        
    }
}