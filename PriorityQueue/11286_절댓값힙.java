import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int x;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                int ab1 = Math.abs(i1);
                int ab2 = Math.abs(i2);
                if(ab1==ab2)    return i1-i2;
                else return ab1-ab2;
            }
        });
        int temp;
        for(int i= 0; i < n; i++){
            x = sc.nextInt();
            if(x!=0){
                queue.add(x);
            }
            else{
                if(queue.isEmpty())
                    System.out.println("0");
                else{
                    temp = queue.poll();
                    System.out.println(temp);
                }
            }
        }
    }
}