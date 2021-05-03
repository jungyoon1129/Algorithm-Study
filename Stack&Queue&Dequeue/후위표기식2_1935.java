import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       int arr[]=new int[n];
        Stack <Double> stack = new Stack<>();
        
        sc.nextLine();
        String str = sc.nextLine();
        
        for(int i = 0; i < arr.length; i++)
            arr[i] =sc.nextInt();
        char temp;
        double a,b;
        for(int i  = 0; i < str.length(); i++){
            temp = str.charAt(i);
            if(temp == '*' || temp == '+' || temp == '-'||temp == '/'){
                b = stack.pop();
                a = stack.pop();
                switch(temp){
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a/ b);
                        break;
                    case '+':
                        stack.push(a + b);
                        break;
                     case '-':
                        stack.push(a - b);
                        break;
                        
                }
            }
             else{
                int index = temp - 'A';
               // System.out.println(index);
                 stack.push((double)arr[index]);
             }
        }
       System.out.println(String.format("%.2f",stack.pop()));
    }
}