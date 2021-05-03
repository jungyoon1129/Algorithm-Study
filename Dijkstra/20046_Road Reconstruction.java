import java.util.*;
import java.io.*;

class Graph{
    int row;
    int column;
    int weight;
    public Graph(int row, int column, int weight){
        this.row = row;
        this.column = column;
        this.weight = weight;
    }
}
public class Main{
    public static void main(String args[]) throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int arr[][] = new int[m+1][n+1];
        int dist[][] = new int[m+1][n+1];
       // int temp;
        
        for(int i = 1; i <= m; i++){
            st =new StringTokenizer(br.readLine()," ");
            for(int j = 1; j <= n; j++){
                
                arr[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = max;
               
            }
        }
        
        dist[1][1] = arr[1][1];
        
        
        if(arr[1][1]==-1)
            System.out.println("-1");
            
        else if(arr[m][n]==-1)
            System.out.println("-1");
            
        else{
            
            
            Graph temp;
        int cur_row;
        int cur_col;
        int distance;
        int next;
        int temp_weight;
        
        
        PriorityQueue<Graph> queue = new PriorityQueue<>(new Comparator<Graph>() {
            public int compare(Graph g1, Graph g2) {
                if(g1.weight <= g2.weight) {
                    return -1;
                }else {
                    return 1;
                }
            }
                });
       
       
       queue.add(new Graph(1,1,arr[1][1]));
        
        while(!queue.isEmpty()){
            temp = queue.poll();
            cur_row = temp.row;
            cur_col = temp.column;
            distance = temp.weight;
            
            //System.out.println(cur_row+" "+cur_col);
           
            
            if(dist[cur_row][cur_col] < distance)    //업데이트 전의 값이므로 스킵
                continue;
                
            //System.out.println(temp.node+" "+dist[temp.node]);
            
            if(cur_row+1 >=1 && cur_row+1<=m){
                temp_weight = arr[cur_row+1][cur_col];
                if(temp_weight!=-1){
                    if(dist[cur_row+1][cur_col] >  temp_weight+distance){
                        dist[cur_row+1][cur_col] =  temp_weight+distance;
                        queue.offer(new Graph(cur_row+1,cur_col,temp_weight+distance));
                    }
                    
                }
            }
            
            if(cur_col+1 >=1 && cur_col+1<=n){
                temp_weight = arr[cur_row][cur_col+1];
                if(temp_weight!=-1){
                    if(dist[cur_row][cur_col+1] >  temp_weight+distance){
                        dist[cur_row][cur_col+1] =  temp_weight+distance;
                        queue.offer(new Graph(cur_row,cur_col+1,temp_weight+distance));
                    }
                    
                }
            }
            
            if(cur_row-1 >=1 && cur_row-1<=m){
                temp_weight = arr[cur_row-1][cur_col];
                if(temp_weight!=-1){
                    if(dist[cur_row-1][cur_col] >  temp_weight+distance){
                        dist[cur_row-1][cur_col] =  temp_weight+distance;
                        queue.offer(new Graph(cur_row-1,cur_col,temp_weight+distance));
                    }
                    
                }
            }
            
            if(cur_col-1 >=1 && cur_col-1<=n){
                temp_weight = arr[cur_row][cur_col-1];
                if(temp_weight!=-1){
                    if(dist[cur_row][cur_col-1] >  temp_weight+distance){
                        dist[cur_row][cur_col-1] =  temp_weight+distance;
                        queue.offer(new Graph(cur_row,cur_col-1,temp_weight+distance));
                    }
                    
                }
            }
            
               
                    
            
        }
        if(dist[m][n]!=max)
            System.out.println(dist[m][n]);
        else
            System.out.println("-1");
        
        }
            
        
    }
}