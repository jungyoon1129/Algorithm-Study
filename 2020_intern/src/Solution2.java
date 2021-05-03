import java.util.*;

public class Solution2 {
	static long max = Integer.MIN_VALUE;
	static boolean visited[] = new boolean[3];
	//static ArrayList<String> list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "50*6-3*2";
		long ans = solution(exp);
		System.out.println(ans);
		
	}
	
	public static long solution(String expression) {
		ArrayList<String> list = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while(st.hasMoreTokens()) {
        	list.add(st.nextToken());
        }
        dfs(0, list);
        return max;
    }
	public static ArrayList<String> deepcopy(ArrayList<String> list ){
		ArrayList<String> newlist = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++)
			newlist.add(list.get(i));
		
		return newlist;
	}
	
	
	public static void dfs(int count, ArrayList<String> list ) {
		if(count == 3) {
			max = Math.max(max, Math.abs(Long.parseLong(list.get(0))));
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ArrayList<String> newlist = deepcopy(list);
				switch(i) {
				case 0:
					newlist = plus(newlist);
					break;
				case 1:
					newlist = minus(newlist);
					break;
				case 2:
					newlist = multi(newlist);
					break;
				}
				dfs(count+1, newlist);
				visited[i] = false;
			}
		}
	}
	public static ArrayList<String> plus(ArrayList<String> list) {
		long a,b;
		//StringBuilder sb;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("+")) {
				a = Long.parseLong(list.remove(i-1));
				list.remove(i-1);
				b = Long.parseLong(list.get(i-1));
				//sb = new StringBuilder(a+b);
				list.set(i-1, Long.toString(a+b));
				i--;
			}
		}
		return list;
	}
	public static ArrayList<String> minus(ArrayList<String> list) {
		long a,b;
		//StringBuilder sb;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("-")) {
				a = Long.parseLong(list.remove(i-1));
				list.remove(i-1);
				b = Long.parseLong(list.get(i-1));
				//sb = new StringBuilder(a+b);
				list.set(i-1, Long.toString(a-b));
				i--;
			}
		}
		return list;
	}
	public static ArrayList<String> multi(ArrayList<String> list) {
		long a,b;
		//StringBuilder sb;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("*")) {
				a = Long.parseLong(list.remove(i-1));
				list.remove(i-1);
				b = Long.parseLong(list.get(i-1));
				//sb = new StringBuilder(a+b);
				list.set(i-1, Long.toString(a*b));
				i--;
			}
		}
		return list;
	}
}
