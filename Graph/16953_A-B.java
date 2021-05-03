import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int temp = b;
        int count = 0;
        boolean success = false;
        
        while(temp != 0){
            if(temp == a){
                success = true;
                 break;
            }
               
            if(temp%2==0){
                temp/=2;
                count++;
            }
            else{
                if(temp%10==1){
                    temp/=10;
                    count++;
                }
                else
                    break;
            }
        }
        if(success)
            System.out.println(++count);
        else
            System.out.println("-1");
    }
}