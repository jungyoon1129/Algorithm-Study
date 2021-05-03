import java.util.*;
import java.io.*;
 
public class Main{
 
     public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        HashMap<Integer, String> map1 = new HashMap<>();
 
        int count = Integer.parseInt(br.readLine());
        String temp="";
        String str="";
         
        for(int i = 0; i < count; i++){
            str = br.readLine();   
            //System.out.println(str);
            map1.put(i, str);             
           // System.out.println(str+" "+i);
        }
         
         int cnt = 0;
         //str = br.readLine();
         
         HashMap<String, Integer> map2 = new HashMap<>();
         for(int i = 0; i < count; i++){    
            str = br.readLine();         
            //System.out.println(str+" "+i);
            map2.put(str, i);  
        }
         
         int origin;
         int now;
         boolean go=false;
         int where=-1; // 어디까지 추월한거 카운트했는지
       
         for(int i = 0; i < count; i++){
             temp = map1.get(i);
             origin = i;
             //System.out.println(temp);
             now = map2.get(temp);
             
            if(now <= where)
            	continue;
            	
            if(now > origin){
                 	//go = true;
                 	cnt += now -where-1;
                 	where = now;
                 	
            }
            else if(now == origin){
                where = now;
            }
                	
            
         }
 
       
 
        System.out.println(cnt);
         
         br.close();
     }
}