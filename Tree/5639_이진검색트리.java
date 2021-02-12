import java.util.*;
import java.io.*;

class Node{
    int value;
    Node left;
    Node right;
    
    public Node(int value){
        this.value = value;      
    }
    public void setLeft(Node left){
       this.left= left;
    }
    public void setRight(Node right){
       this.right= right;
    }
    public Node getLeft(){
        return left;
    }
    public Node getRight(){
        return right;
    }
    public int getValue(){
        return value;
    }
    
    public static Node addNode(Node node, int current){
        Node temp;
        if(node==null){
            return new Node(current);
        }
        else{
            if(node.getValue() >current){
                temp= addNode(node.left, current);
                node.left = temp;
            }
            else{
                temp= addNode(node.right, current);
                node.right = temp;
            }
            
        }
        return node;
    }
}

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[])throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        
        int current;
        String input;
        Node node;
        
        current = Integer.parseInt(br.readLine());
        node = new Node(current);
        
        while((input = br.readLine()) != null){
            current = Integer.parseInt(input);
            node = node.addNode(node, current);
            
        }
        printNode(node);
       bw.flush();
        
    }
    
    public static void printNode(Node node) throws IOException{
        Node temp;
        temp = node.getLeft();
        if(temp!=null)
            printNode(temp);
        temp = node.getRight();
        if(temp!=null)
            printNode(temp);
        bw.write(node.getValue()+"\n");
    }
    
}