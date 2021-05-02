import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String str;      
        StringTokenizer st;
        LinkedList<Integer> adj[] = new LinkedList[n+1];
        int check[] = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i <= n; i++){
            check[i] = -1;
            adj[i] = new LinkedList<>();
            st = new StringTokenizer(br.readLine()," ");
            int tmp;
            
            while(st.hasMoreTokens()){
                tmp = Integer.parseInt(st.nextToken()); 
                if(tmp==0)
                    break;
                adj[i].add(tmp);
                //check[tmp]=0;
            }
            
        }
        int m =Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            int s = Integer.parseInt(st.nextToken());
            queue.add(s);
            check[s]=0;
        }
        Queue<Integer> queue1 = new LinkedList<>();
                      int count = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            
            Iterator<Integer> itr = adj[v].iterator();
            while(itr.hasNext()){
                int newv = itr.next();
                if(check[newv]!=-1)    continue;
                count = 0;
                
                Iterator<Integer> itr1 = adj[newv].iterator();
                while(itr1.hasNext()){
                    int temp = itr1.next();
                    if(check[temp]!=-1)    count++;
                }
                if(count * 2 >= adj[newv].size())
                    queue1.offer(newv);
            
            }
            if(queue.isEmpty()){
                while(!queue1.isEmpty()){
                    int tmp = queue1.poll();
                    check[tmp] = check[v]+1;
                    queue.offer(tmp);
                }
            }
        }
        for(int i =1; i <= n; i++)
            bw.write(check[i]+" ");
        bw.flush();
    }
                      
}