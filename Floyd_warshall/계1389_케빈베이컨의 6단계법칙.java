import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
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
        
        for(int i = 1; i <= m; i++){
            current= sc.nextInt();
            next = sc.nextInt();
            //distance = sc.nextInt();
            dist[current][next] = 1;
            dist[next][current] = 1;
        }
        
        int count[] = new int[n+1];
      
        
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
        
        
        
        int min = max;
        int minIndex=-1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                count[i]+= dist[i][j];
            }
            if(min > count[i]){
                min = count[i];
                minIndex = i;
            }
               
        }
        
        System.out.println(minIndex);
              
    }
}