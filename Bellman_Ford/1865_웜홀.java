import java.util.*;
class Graph{
    int node;
    int weight;
    public Graph(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int max = Integer.MAX_VALUE;
    
        int tc = sc.nextInt();
        
        for(int l = 0; l < tc; l++){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int w = sc.nextInt();
        
        ArrayList<Graph> arr[] = new ArrayList[n+1];
        int dist[] = new int[n+1];
        boolean visited[] = new boolean[n+1];
        
        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        
        Graph temp;
        int current;
        int distance;
        int next;
        boolean minus= false;
        
       LinkedList<Graph> queue = new LinkedList<>();
       
       
       //queue.add(new Graph(1,0));
       //dist[1]=0;
     
        for(int i = 1; i <= m; i++){
            current= sc.nextInt();
            next = sc.nextInt();
            distance = sc.nextInt();
            arr[current].add(new Graph(next,distance));
            arr[next].add(new Graph(current,distance));
                
        }
        
        for(int i = 1; i <= w; i++){
            current= sc.nextInt();
            next = sc.nextInt();
            distance = sc.nextInt();
            arr[current].add(new Graph(next,-distance));
            
                
        }
        
        for(int i = 1; i <= n; i++){
            dist[i]=max;
       }
      
        for(int x = 1; x <= n; x++){
            if(visited[x])  continue;
            
            
            else{
                dist[x] = 0;
                for(int i = 1; i <= n; i++){
           
           
           for(int j = 1; j <= n; j++){
               if(dist[j]==max) //방문한적 없는 노드
                    continue;
                visited[j]=true;
               for(int k = 0; k < arr[j].size(); k++){
                   temp = arr[j].get(k);
                 //System.out.println(temp.node+" "+dist[temp.node]);
                    if(dist[temp.node] > temp.weight+dist[j]){
                        if(i==n){    
                            minus = true;
                            break;
                        }
                        dist[temp.node] = temp.weight+dist[j];
                       visited[temp.node]=true;
                    //System.out.println(temp.node+" "+dist[temp.node]);
                    }
               }
           }
            
           
        }
            }
        }
       
        
        if(minus){
            System.out.println("YES");
        }
            else
            {
            
                System.out.println("NO");
            
            }
        
        }
        
    }
}