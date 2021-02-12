import java.util.*;
import java.io.*;

class Node{
    int value;
    int weight;
    
    public Node(int value,int weight){
        this.value = value; 
        this.weight = weight;
    }
    
}

public class Main{
    static boolean visit[];
    static ArrayList<Node> arr[];
   static int  node;
    static int maxweight;
   // static int temp;
    
    public static void main(String args[])throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int n = Integer.parseInt(br.readLine());
        
        String input;
      
        StringTokenizer st;
        arr = new ArrayList[n+1];
        visit = new boolean[n+1];
        int child, parent, weight;
        
        for(int i=0; i <= n; i++)
            arr[i] = new ArrayList<>();
        
        while((input = br.readLine()) != null){
            st = new StringTokenizer(input," ");
            parent = Integer.parseInt(st.nextToken());
            child =Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            
            arr[parent].add(new Node(child,weight));
            arr[child].add(new Node(parent,weight));
            
        }
        Node temp;
       // int point;
        //for(int i =0; i < arr[1].size(); i++){
        //    temp = arr[1].get(i);
        //    
        //}
        
        visit[1]=true;
        dfs(1,0);
        visit[1]=false;
       // System.out.println(node);
       // System.out.println(maxweight);
             
        maxweight=0;
        visit[node]=true;
        dfs(node,0);
        visit[node]=false;
        
       
      //  System.out.println(point);
        System.out.println(maxweight);
     
        
    }
    
    public static void dfs(int start, int weight){
        //.out.println("start "+start);
        for(int i = 0; i < arr[start].size(); i++){
            // System.out.println("start "+start+" size "+arr[start].size());
            int temp = arr[start].get(i).value;
            // System.out.println(temp);
            if(!visit[temp]){
              //  System.out.println("4 "+visit[4]);
                //System.out.println("true "+temp);
                visit[temp]=true;
                dfs(temp, weight+arr[start].get(i).weight);
                visit[temp] = false;
                //System.out.println("false "+temp);
            }
           // System.out.println(" after 4 "+visit[4]);
            
        }
        if(maxweight<weight){
            node = start;
            maxweight= weight;
        }
        
        //System.out.println("end "+start);
        //System.out.println(maxweight);
        
    }
}