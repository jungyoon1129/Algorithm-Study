import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String temp = "";
        char character;
        Stack <Character> stack;
        //Stack <Character> stack2;
        boolean prob = false; char popitem;
        
        while(true){
            stack = new Stack<>();
           // stack2 = new Stack<>();
            temp = sc.nextLine();
            if(temp.equals("."))    break;
            for(int i = 0; i < temp.length(); i++){
                character = temp.charAt(i);
                if(character=='('|| character == '[')
                    stack.push(character);
                else if(character == ')'){
                    if(stack.empty()){
                        prob = true;
                        break;
                    }
                    popitem = stack.peek();
                    if(popitem != '('){
                         prob = true;
                        break;
                    }
                    stack.pop();
                        
                    
                }
                else if(character == ']' ){
                    if(stack.empty()){
                        prob = true;
                        break;
                    }
                    popitem = stack.peek();
                    if(popitem != '['){                       
                        prob = true;
                        break;
                    }
                    stack.pop();
                    
                }
                                                       
            }
            if(prob || !stack.empty())
                System.out.println("no");
            else
                System.out.println("yes");
            prob = false;
        }
    }
}