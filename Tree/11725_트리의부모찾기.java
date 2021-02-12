import java.util.*;

public class Main{
    static int parent[];
    static ArrayList<Integer> list[];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //BufferedWriter bf = new BufferedWriter(new )
        
        int n = sc.nextInt();
        //Tree tree = new Tree(n);
        int temp, index1, index2;
        int root = 0;
        //int num[] = new int[n+1];
        parent = new int[n+1];
        
       list = new ArrayList[n+1];
        
        for(int i =  1; i <= n; i++) 
            list[i] = new ArrayList<>();
            
        for(int i = 1; i < n; i++){  
            index1 = sc.nextInt();
            index2 = sc.nextInt();
            
            list[index1].add(index2);
            list[index2].add(index1);
  
        }
        dfs(-1,1);

        for(int i =  2; i <= n; i++)
            System.out.print(parent[i]+" ");
    
    }    
        
    public static void dfs(int previous, int current){
       
            parent[current]=previous;
        
        
            for(int i = 0; i < list[current].size();i++){
                int temp = list[current].get(i);
               // System.out.println(current+" "+ temp);
                if(parent[temp] == 0)
                    dfs(current, temp);
            }
        
        
    }
    
}