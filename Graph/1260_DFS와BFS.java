import java.util.*;

class Graph{
    int n;
    LinkedList <Integer> adj[];
    //boolean visited[];
    int newelement;
    
    Graph(int n){
        this.n = n;
        adj = new LinkedList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new LinkedList<>();
       
    }
    
    public void addEdge(int v, int s){
        adj[v-1].add(s-1);
        adj[s-1].add(v-1);
    }
    
    public void sortList(){
        for(int i = 0; i < adj.length; i++)
            Collections.sort(adj[i]);
    }
    
    public void dfs(int v){
        boolean visited[] = new boolean[n];
        dfs_util(v,visited);
    }
    
    public void dfs_util(int v, boolean visited[]){
        visited[v] = true;
        System.out.print((v+1) + " ");
        Iterator<Integer> itr = adj[v].iterator();
        
        while(itr.hasNext()){
            newelement = itr.next();
            if(!visited[newelement])
                dfs_util(newelement, visited);
        }
    }
    
    public void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.add(v);
        visited[v]=true;
        
        //Iterator<Integer> itr = adj[v].iterator();
        //int new;
        while(!queue.isEmpty()){
            newelement = queue.poll();
            System.out.print((newelement+1) + " ");
            Iterator<Integer> itr = adj[newelement].iterator();
            while(itr.hasNext()){
                int temp = itr.next();
                if(!visited[temp]){
                    visited[temp]=true;
                    queue.offer(temp);
                }
            }
        }
    }
   
}
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        Graph g = new Graph(n);
            
        for(int i = 0; i < m; i++){
            g.addEdge(sc.nextInt(), sc.nextInt());
        }
        g.sortList();
        g.dfs(v-1);
        System.out.println();
        g.bfs(v-1);
    }
}