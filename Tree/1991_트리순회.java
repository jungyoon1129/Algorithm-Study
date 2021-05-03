import java.util.*;
import java.io.*;

class Node{
    int parent;
    int value;
    int left;
    int right;
    
     public Node(int value, int parent){
        this.value = value;
        this.parent = parent;
    }
    public Node(int value){
        this.value = value;      
    }
   public void setLeft(int left){
       this.left= left;
   }
    public void setRight(int right){
       this.right= right;
   }
    
    public void setParent(int i ){
        this.parent = i;
    }
    public int getLeft(){
        return left;
    }
    public int getRight(){
        return right;
    }
}
class Tree{
    Node arr[];
    int root = -1;
    boolean visited[];
    int temp;
    int count = 0;
    int printarray[];int order=0;
    char ch;
    
    public Tree(int num){
        arr = new Node[num];
        for(int i= 0; i < num; i++)
            arr[i] = new Node(i);
        visited = new boolean[num];
        printarray = new int[num];
    }
    
    public void addNode(int i, int left, int right){
        arr[i].setLeft(left);
        arr[i].setRight(right);
    }
    
    public void printarr(){
       // char ch;
        for(int i = 0; i < printarray.length; i++){
            ch = (char)(printarray[i]+'A');
            System.out.print(ch);
        }
        System.out.println();
        order = 0;
        printarray=new int[arr.length];
    }
    
    public void preorder(int current){
        printarray[order++]=current;
        temp = arr[current].getLeft();
        if(temp!=-1){
            preorder(temp);
        }
        temp = arr[current].getRight();
        if(temp!=-1){
            preorder(temp);
        }
        
        
    }
    
    public void inorder(int current){
       
        temp = arr[current].getLeft();
        if(temp!=-1){
            inorder(temp);
        }
        printarray[order++]=current;
        temp = arr[current].getRight();
        if(temp!=-1){
            inorder(temp);
        }
        
    }
    
    public void postorder(int current){
        temp = arr[current].getLeft();
        if(temp!=-1){
            postorder(temp);
        }
        
        temp = arr[current].getRight();
        if(temp!=-1){
            postorder(temp);
        }
         printarray[order++]=current;
    }
   
    
}


public class Main{
    public static void main(String args[])throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree(n);
      
        StringTokenizer st;
        int val, left, right;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            val = st.nextToken().charAt(0)-'A';
            left = st.nextToken().charAt(0)-'A';
            right = st.nextToken().charAt(0)-'A';
            if(left=='.'-'A')
                left = -1;
            if(right == '.'-'A')
                right = -1;
            tree.addNode(val,left,right);
        }
        //int ans[];
        tree.preorder(0);
        tree.printarr();
        tree.inorder(0);
        tree.printarr();
        tree.postorder(0);
        tree.printarr();
        
    }
    
}