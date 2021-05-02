import java.util.*;
import java.io.*;

 
public class Main{
 	// 에라토스테네스의 채
    static int arr[] = new int[5000001];    // 소수:true
    
     public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));       
         
         arr[0] = -1; arr[1] = -1;
         
         for(int i =2; i < arr.length; i++)
             arr[i] = i;        
         
         for(int i =2; i < arr.length; i++){
             if(arr[i] == i){    //i가 소수라면 i를 제외한 배수들에 최소 소수를 저장해놓는다.
                 for(int j = i+i; j <= 5000000; j+=i){
                     if(arr[j] == j)
                         arr[j] = i;
                 }
             }
         }
         
         int n = Integer.parseInt(br.readLine());
         StringTokenizer st = new StringTokenizer(br.readLine());
         int a;
         
         for(int i = 0; i < n; i++){
             a = Integer.parseInt(st.nextToken());
             while(a!=1){           
                bw.write(arr[a]+" ");
                a /= arr[a];
            }
            bw.write("\n");
        }

     		
         bw.flush();
         bw.close();
         br.close();
        
     }   
}