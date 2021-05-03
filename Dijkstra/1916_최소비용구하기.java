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
        
        int max = 987654321;
    
        int v= sc.nextInt();
        int e = sc.nextInt();
      //  int start = sc.nextInt();
        ArrayList<Graph> arr[] = new ArrayList[v+1];
        int dist[] = new int[v+1];
        
        for(int i = 1; i <= v; i++){
            arr[i] = new ArrayList<>();
        }
        
         Graph temp;
        int current;
        int distance;
        int next;
        
        PriorityQueue<Graph> queue = new PriorityQueue<>(new Comparator<Graph>() {
 
           
            public int compare(Graph g1, Graph g2) {
                if(g1.weight <= g2.weight) {
                    return -1;
                }else {
                    return 1;
                }
            }
                });
       
       
      // queue.add(new Graph(start,0));
     
        for(int i = 1; i <= e; i++){
            current= sc.nextInt();
            next = sc.nextInt();
            distance = sc.nextInt();
            arr[current].add(new Graph(next,distance));
        }
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        queue.add(new Graph(start,0));
        
        for(int i = 1; i <= v; i++){
            if(i == start){
                dist[i]=0;
            }
            else{
                //queue.offer(new Graph(i,max));
                dist[i]=max;
            }
        }
      
    
        
        while(!queue.isEmpty()){
            temp = queue.poll();
            current=temp.node;
            distance = temp.weight;
           
            
            if(dist[current] < distance)    //업데이트 전의 값이므로 스킵
                continue;
                
            //System.out.println(temp.node+" "+dist[temp.node]);
            
            for(int i = 0; i < arr[current].size(); i++){
                temp = arr[current].get(i);
                 //System.out.println(temp.node+" "+dist[temp.node]);
                if(dist[temp.node] > temp.weight+distance){
                    dist[temp.node] = temp.weight+distance;
                    queue.offer(new Graph(temp.node,temp.weight+distance));
                    //System.out.println(temp.node+" "+dist[temp.node]);
                }
                    
            }
        }
        
        
                System.out.println(dist[end]);
        
    }
}