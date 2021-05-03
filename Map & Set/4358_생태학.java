import java.util.*;
import java.io.*;

public class Main{

     public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        TreeMap<String, Integer> map = new TreeMap<>();
        
        int count = 0;
        int temp;
        String str = br.readLine();
         
        while(str!=null){
            count++;
            if(!map.containsKey(str)){
                map.put(str,1);
            }
            else{
                temp = map.get(str); 
                map.replace(str, temp+1);
            }
            str = br.readLine();
        }
         
        for (String key : map.keySet()) {
            int value = map.get(key);
            bw.write(key +" " + String.format("%.4f", (double)value/count*100)+"\n");
        }
         
         bw.flush();
         bw.close();
         br.close();
     }
}