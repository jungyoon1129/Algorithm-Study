import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 

        int adj[][] = new int[n+1][2];

      //  ArrayList<Integer> arr = new ArrayList<>();
        char dir[] = new char[m];
        
        for(int i = 1;i <= n ; i++){
            //adj[i] = new LinkedList<>();
            st  = new StringTokenizer(br.readLine()," ");
       
           adj[i][0] = Integer.parseInt(st.nextToken());
            adj[i][1] = Integer.parseInt(st.nextToken());   
           
        }
        String str;
        
        
        int x=0;
        
        st  = new StringTokenizer(br.readLine()," ");
        char  ch; int leftcnt= 0;
       while(st.hasMoreTokens()){
           ch = st.nextToken().charAt(0);
           if(ch == 'L'){
               dir[x++]=0;
           }
           else
               dir[x++]=1;
          // System.out.println(ch);
           
       }

        int ans[] =new int[n+1];

        int tmp=1;
        int start =1;
        
       for(int i = 0; i < k; i++) {
           if(ans[start]==0){
               for(int j = 0; j < m; j++) 
		tmp=adj[tmp][dir[j]];
					
	ans[start]=tmp;
	start=tmp;
           }
           else
               start = ans[start];		
	}
        
       bw.write(start+"\n");
       bw.flush();
    }
}