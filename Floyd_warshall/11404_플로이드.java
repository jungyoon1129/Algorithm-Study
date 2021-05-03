import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.MAX_VALUE;
    
        int n= sc.nextInt();
        int m = sc.nextInt();
        
        int dist[][] = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++){
          
           for(int j = 1; j <= n; j++){
               if(i==j) dist[i][j] = 0;
                else dist[i][j] = max;
           }
        }
       
        int current;
        int next;
        int cost;
        
     
        for(int i = 1; i <= m; i++){
            current= sc.nextInt();
            next = sc.nextInt();
            cost = sc.nextInt();

	//길이 여러개가 있다면 최소비용으로 저장                       
            dist[current][next] =Math.min(dist[current][next], cost);	         
        }
        
       
        
       for(int i = 1; i <= n; i++){
           //i는 경유하는 노드
           
           for(int j = 1; j <= n; j++){
                 
               for(int k = 1; k <=n; k++){
                   if(dist[j][i]!=max && dist[i][k]!=max  ){
                       if(dist[j][k] > dist[j][i]+dist[i][k])
                        dist[j][k] = dist[j][i]+dist[i][k];
                   }
               }
           }
        }
      
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][j]==max)	sb.append("0 ");
                else sb.append(dist[i][j]+" ");
                
            }
            sb.append("\n");
             
        }
        
       bw.write(sb.toString());
       bw.flush();
       bw.close();
        
        
    }
}