import java.util.*;
import java.io.*;
 
public class Main{
 
 static int arr[] = new int[100001];
 
     public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
         int n = Integer.parseInt(br.readLine());
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         int temp1 =Integer.parseInt(st.nextToken());
         int temp2;
         boolean flagzero = false;
          
         if(temp1 == 0){
              flagzero = true;
              
        }
        else{
            //처음값 셋팅
            if(temp1 < 0) multi(-temp1);
            else multi(temp1);
      
         char operator;
        
         for(int i = 0; i < n-1; i++){
             operator = st.nextToken().charAt(0);
             temp2 = Integer.parseInt(st.nextToken());
             
             switch(operator){
                                    
                 case '*': 
                 	if(temp2 == 0){
                 		flagzero = true;
                 		break;
                 	}
                     else if(temp2 < 0) multi(-temp2);
                     else multi(temp2);
                     break;
                     
                 case '/': 
                     if(temp2 < 0) divi(-temp2);
                     else divi(temp2);
                     break;
                     
             }
         }
        }
        
        if(flagzero)
        	System.out.println("mint chocolate");
        else{
        	boolean integer = true;
        	for(int i = 1 ; i < arr.length; i++){
         		if(arr[i] < 0)	integer = false;
        	}
         
         
        	if(integer)
        		System.out.println("mint chocolate");
        	else
            	System.out.println("toothpaste");
            	
        }
     }
     
     public static void multi(int a){
     	
     	for(int i = 2; i*i <= a; i++){
     		if(a % i == 0){
     			while(a % i == 0){
     				arr[i]++;
     				a /= i;
     			}
     		}
     	}
     		if(a != 1)	
     			arr[a]++;

     	
     	
     	
     }
     
     public static void divi(int a){
     	for(int i = 2; i*i <= a; i++){
     		if(a % i == 0){
     			while(a % i == 0){
     				arr[i]--;
     				a /= i;
     			}
     		}
     	}
     	
     		if(a != 1)	
     			arr[a]--;
     
     }
}