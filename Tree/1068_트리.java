import java.util.*;

class Node{
    int parent;
    int value;
    ArrayList<Integer> child = new ArrayList<>();
    
     public Node(int value, int parent){
        this.value = value;
        this.parent = parent;
    }
    public Node(int value){
        this.value = value;      
    }
    public void addChild(int c){
        child.add(c);
    }
    
    public int getChildSize(){
        return child.size();
    }
    
    public int getChild(int i){
        return child.get(i);
    }
    
    public void setParent(int i ){
        this.parent = i;
    }
}
class Tree{
    Node arr[];
    int root = -1;
    boolean visited[];
    int temp;
    int count = 0;
    
    public Tree(int num){
        arr = new Node[num];
        for(int i= 0; i < num; i++)
            arr[i] = new Node(i);
        visited = new boolean[num];
    }
    
    public void addNode(int i, int parent){
        arr[i].setParent(parent);
        if(parent == -1)
            root = i;
        else{
            arr[parent].addChild(i);
        }
    }
     public void dfs(int current,int target){
        visited[current] = true;
        if(current==target)
         return;
        if(arr[current].getChildSize()==0){
            count++;
        }
         else{
             for(int i = 0; i < arr[current].getChildSize(); i++){
                 temp = arr[current].getChild(i);
                 if(temp!=target && !visited[temp])
                     dfs(temp, target);
                else{
                    if(arr[current].getChildSize()==1)
                        count++;
                }
                 
             }
         }
    }
    
    public void getCount(){
        System.out.println(count);
    }
    
}


public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Tree tree = new Tree(n);
        int temp, index;
        int root = 0;
        
        for(int i = 0; i < n; i++){           
            index = sc.nextInt();
            tree.addNode(i,index);  
            if(index==-1)
                root=i;
        }
        int target = sc.nextInt();
        //System.out.println(root);
        
        tree.dfs(root, target);
        tree.getCount();
    }
    
}