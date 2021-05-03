import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
       
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        
        Integer arr[] = new Integer[n];
        for(int i =0; i < arr.length; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i =0; i < arr.length; i++){
            writer.write(arr[i] +" ");
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}