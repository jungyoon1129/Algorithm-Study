import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        
        int arr[] = new int[200001];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1; i< arr.length; i++)
            arr[i] = i*i;
        
        int a = 1; int b =1;int temp;
        while(true){
            if(b>=arr.length)    break;
            temp = arr[b] - arr[a];
            if(temp==g)
                list.add(b);
            if(temp > g)
                a++;
            else 
                b++;
           
        }
        if(list.size()==0)
            System.out.println("-1");
        else{
            Collections.sort(list);        
            for(int i:list)
                System.out.println(i);
        }
    }
}