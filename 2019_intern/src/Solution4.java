import java.util.*;

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long room[] = {1,3,1,2,1};
		long k = 10;
		long arr[] =solution(k,room);
		for(long i: arr)
			System.out.print(i+" ");
	}

	public static long[] solution(long k, long[] room_number) {
       // ArrayList<Long> room = new ArrayList<>();
		HashMap<Long,Long> room = new HashMap<>();
		 long arr[] = new long[room_number.length];
		 
        for(int i = 0; i < room_number.length; i++) {
        	if(!room.containsKey(room_number[i])) {
        		room.put(room_number[i],room_number[i]+1);
        		arr[i] = room_number[i];
        	}
        	else {
        		//포함하는 경우
        		
        		ArrayList<Long> temp = new ArrayList<>();
                //temp.add(room_number[i]);
                arr[i] = room_number[i];
                
        		while(true) {        			
        			arr[i] = room.get(arr[i]);      
        			if(!room.containsKey(arr[i]))
        				break;
        			
        			temp.add(arr[i]);
        		}
        		for(int j = 0; j < temp.size(); j++) {
        			//room.remove(arr[i]);
        			room.replace(temp.get(j), arr[i]+1);
        		}
        		//room.replace(room_number[i], arr[i]+1);
        		room.put(arr[i], arr[i]+1);
        	}
        }
       
        return arr;
    }
}
