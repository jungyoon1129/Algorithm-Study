import java.util.*;

public class Solution2 {
	public static void main(String args[]) {
		int arr[] = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	public static int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "{}");
        String str;
        int max = 0;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        while(st.hasMoreTokens()) {
        	str =  st.nextToken();
        	if(str.equals(","))
        		continue;
        	StringTokenizer st1 = new StringTokenizer(str, ",");
        	ArrayList<Integer> tmp = new ArrayList<>();
        	
        	while(st1.hasMoreTokens()) {
        		tmp.add(Integer.parseInt(st1.nextToken()));
        	}
        	arr.add(tmp);
        }
       
        Collections.sort(arr, new Comparator<ArrayList<Integer>>() {
        	public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        		return a.size() - b.size();
        				
        	}
        });
        int newarr[] = new int[arr.get(arr.size()-1).size()];
        
        int num = 0;
        for(int i = 0; i < arr.size(); i++) {
        	//Collections.sort(arr.get(i));
        	if(arr.get(i).size() == 1) {
        		newarr[num] = arr.get(i).get(0);
        		//visited[newarr[num++]]++;
        		num++;
        	}
        	else {
        		for(int j = 0; j < num; j++) {
        			if(arr.get(i).contains(newarr[j]))
        				arr.get(i).remove((Integer)newarr[j]);
        		}
        		
        		newarr[num] = arr.get(i).get(0);
        		num++;
        	}
        		
        }
        return newarr;
    }
	
	
	public static int[] deepcopy(int visited[]) {
		int newvisited[] = new int[visited.length];
		for(int i = 0; i < newvisited.length; i++) {
			newvisited[i] = visited[i];
		}
		return newvisited;
	}

}
