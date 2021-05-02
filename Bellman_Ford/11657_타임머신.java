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
    
        int n= sc.nextInt();
        int m = sc.nextInt();
        
        ArrayList<Graph> arr[] = new ArrayList[n+1];
        long dist[] = new long[n+1];
        
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
       dist[1]=0;
     
        for(int i = 1; i <= m; i++){
            current= sc.nextInt();
            next = sc.nextInt();
            distance = sc.nextInt();
            arr[current].add(new Graph(next,distance));                      
        }
        
        for(int i = 2; i <= n; i++){
            dist[i]=max;
        }
      
        
       for(int i = 1; i <= n; i++){
           
           
           for(int j = 1; j <= n; j++){
               if(dist[j]==max) //방문한적 없는 노드
                    continue;
                    
               for(int k = 0; k < arr[j].size(); k++){
                   temp = arr[j].get(k);
                 //System.out.println(temp.node+" "+dist[temp.node]);
                    if(dist[temp.node] > temp.weight+dist[j]){
                        if(i==n){    
                            minus = true;
                            break;
                        }
                        dist[temp.node] = temp.weight+dist[j];
                       
                    //System.out.println(temp.node+" "+dist[temp.node]);
                    }
               }
           }
            
           
        }
        
        if(minus){
            System.out.println("-1");
        }
        else
        {
            for(int i=2; i < dist.length; i++){
            if(dist[i] == max)
                System.out.println("-1");
            else
                System.out.println(dist[i]);
            }
        }
        
    }
}