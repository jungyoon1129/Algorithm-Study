import java.util.*;
class graph{
    int n;
    int count;
    public graph(int n, int count){
        this.n = n;
        this.count= count;
    }
}

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        boolean check[]= new boolean[100001];
        Queue<graph> queue = new LinkedList<>();
        queue.offer(new graph(n,0));
        check[n] = true;
        graph temp;int count = 0;
        int temp_n;
        if(n==k)
            count=0;
        else{
        while(!queue.isEmpty()){
            temp = queue.poll();
            
                
            count = temp.count+1;
            temp_n= temp.n;
            if((temp.n - 1) >= 0 && !check[temp_n-1] ){
                if(temp_n-1 == k)
                    break;
                check[temp_n-1] = true;
                //queue.offer(temp-1);
                queue.offer(new graph(temp_n-1,count));
                
            }
            if((temp_n + 1) <= 100000 && !check[temp_n+1]){
                if(temp_n+1 == k)
                break;
                check[temp_n+1] = true;
                //queue.offer(temp+1);
                queue.offer(new graph(temp_n+1,count));
            }
            if(temp_n*2 <= 100000 && !check[temp_n*2]){
                if(temp_n*2 == k)
                break;
                check[temp_n*2] = true;
                //queue.offer(temp*2);
                queue.offer(new graph(temp_n*2,count));
            }
        }
    }
        System.out.println(count);
    }
}