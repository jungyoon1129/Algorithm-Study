import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = sc.nextInt();
        int arr[] = new int[total];
        //ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i <= n; i++)
            queue.offer(i);
            
        int topcompare, tailcompare, temp;
        int count = 0, sum = 0;
        for(int i = 0; i <total; i++){
            int target = sc.nextInt();
            count = 0;
            while(true){
                temp = queue.poll();
                if(target == temp){
                    if(count < queue.size()-count+1)
                        sum+=count;
                    else 
                        sum+=(queue.size()-count+1);
                        //System.out.println("size "+queue.size()+" count "+count);
                    break;
                }
                else{
                    queue.offer(temp);
                }
                count++;
            }
            
        }
        System.out.println(sum);
    }
}