import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue =new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= n ; i++){
            queue.offer(i);
        }
        int count = 0;
        int temp;
        while(queue.size() != 0){
            temp = queue.poll();
            if(count++ == k-1){
                count = 0;
                list.add(temp);
                continue;
            }
            queue.offer(temp);
                
        }
        
        System.out.print("<");
        for(int i=0;i<list.size()-1; i++)
            System.out.print(list.get(i)+", ");
         System.out.print(list.get(list.size()-1));
        System.out.print(">");
        
    }
}