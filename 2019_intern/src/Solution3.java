import java.util.*;
import java.util.regex.Pattern;

public class Solution3 {
	static int count = 0;
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String []banned_id = {"fr*d*", "*rodo", "******", "******"};
		
		int ans = solution(user_id, banned_id);
		System.out.println(ans);
	}
	public static int solution(String[] user_id, String[] banned_id) {
		StringBuilder sb = null;
        for(int i = 0; i < banned_id.length; i++) {
        	sb = new StringBuilder();
        	for(int j = 0; j < banned_id[i].length(); j++) {      		
        		char c =banned_id[i].charAt(j);
        		if(c=='*') {
        			sb.append('.');
        		}
        		else {
        			sb.append(c);
        		}
        	}
        	String t =sb.toString();
        	banned_id[i] = t;
        }
        visited = new boolean[user_id.length];
        arr = new ArrayList<>();
        
        dfs(user_id, banned_id,0);
        return count;
    }
	public static boolean canadd() {
		//boolean fail = false;
		int count = 0;
		for(int i = 0; i< list.size(); i++) {
			count = 0;
			for(int j = 0; j < list.get(i).size(); j++) {
				
				if(arr.get(j)!=list.get(i).get(j)) {
					break;
				}
				else {
					count++;
				}
			}
			if(count == list.get(i).size() )
				return false;
		}
		return true;
	}
	public static  ArrayList<Integer> deepcopy(){
		ArrayList<Integer> newa= new ArrayList<Integer>();
		for(int i = 0; i < arr.size(); i++) {
			newa.add(arr.get(i));
		}
		return newa;
	}
	public static void dfs(String []user, String[] banned, int banid) {
		if(banid == banned.length) {
			Collections.sort(arr);
			if(canadd()) {
				count++;
				list.add(arr);
			}
			
			//arr.clear();
			arr = deepcopy();
			return;
		}
		for(int j = 0; j < user.length; j++) {
			if(!visited[j] && Pattern.matches(banned[banid], user[j])) {
				visited[j] = true;
				arr.add(j);
				dfs(user, banned, banid+1);
				visited[j] = false;
				arr.remove((Integer)j);
			}
		}
		
	}
}
