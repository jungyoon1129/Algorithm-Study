import java.util.*;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"a", "c", "b", "a", "c", "b", "a"};
		int ans[] = solution(gems);
		for(int i : ans) {
			System.out.println(i);
		}
	}

	public static int[] solution(String[] gems) {
        int a = 0, b=0;
        int count = 0;
        int ansa, ansb;
        int dist = Integer.MAX_VALUE;
        int anscount = 0;
        int num = 1;
        HashMap<String,Integer> list = new HashMap<>();
        ArrayList<String> tmp = new ArrayList<>();
        
        for(int i = 0; i < gems.length; i++) {
        	if(tmp.isEmpty()) {
        		tmp.add(gems[i]);
        	}
        	else {
        		if(tmp.contains(gems[i]))
        			continue;
        		else {
        			tmp.add(gems[i]);
        			num++;
        		}
        	}
        }
        
        count = 1;
        ansa=0;
        ansb=0;
        //dist = 0;
        list.put(gems[0],1);
        count=1;
        anscount = count;
        int temp;
        if(count == num) {
        	dist = 0;
        }
        else {
        	while(true) {
            	if(count < num) {
            		b++;
            		if(b >= gems.length)
            			break;
            		if(list.containsKey(gems[b])) {
            			temp = list.get(gems[b]);
            			list.replace(gems[b], temp+1);
            		}
            		else {
            			list.put(gems[b], 1);
            			count++;
            		}
            		
            	}
            	else if(count >= num) {
            		
            		if(dist > Math.abs(b-a)) {
            			ansa = a;
            			ansb = b;
            			dist = Math.abs(b-a);
            		}
            		temp = list.get(gems[a]);
            		if(temp!=1) {
            			list.replace(gems[a], temp-1);
            			if(a+1>=gems.length)
                			break;
            			++a;
            			//dist--;
            		}
            		else {
            			list.remove(gems[a++]);
            		}
            		count = list.size();
            		
            	}
            }
        }
        
        int ans[] = new int[2];
        ans[0] = ansa+1;
        ans[1] = ansb+1;
        return ans;
        
    }
}
