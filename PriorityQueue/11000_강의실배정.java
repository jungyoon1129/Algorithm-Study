import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[][]=new int[n][2];
        for(int i =0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            
        }
        
        Arrays.sort(arr, new Comparator<int []>(){
            public int compare(int arr1[], int arr2[]){
                if(arr1[0]==arr2[0])
                    return arr1[1]-arr2[1];
                else
                    return arr1[0]-arr2[0];
            }
        });
        
        int start;
        int end;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //끝나는 시간을 우선순위 큐에 넣는다.
        
        for(int i =0 ; i<n; i++){
            start = arr[i][0];
            end = arr[i][1];
            //큐에 들어있는 가장 빨리 강의가 끝나는 강의실의 종료시간과 현재 강의의 시작 시간을 비교해서 새로운 강의실을 사용하지 않아도 되면 poll
            if(queue.size()!=0 && queue.peek()<= start)
                queue.poll();
            queue.offer(end);
        }
        System.out.println(queue.size());
        
        
    }
}