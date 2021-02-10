import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int index, count = 0;
        int m,n,temp;
        for(int i = 0; i < total; i++){
            n = sc.nextInt();
            m = sc.nextInt();
            
            for(int j = 0; j < n; j++){
                temp = sc.nextInt();
                list.add(temp);
                queue.offer(temp);
            }
            Collections.sort(list);
            Collections.reverse(list);
            index = m;
            while(queue.size()!=0){
               temp = queue.poll();
                if(temp==list.get(0)){
                    count++;
                    //System.out.println("count "+count+" temp "+temp+" index "+index);
                    list.remove(0);
                    if(index == 0)
                        break;
                }
                else{
                    //System.out.println(" index "+index);
                    queue.offer(temp);
                }
                index = (index-1+queue.size())%queue.size();
            }
            System.out.println(count);
            count = 0;
            list.clear();
            queue.clear();
        }
    }
}