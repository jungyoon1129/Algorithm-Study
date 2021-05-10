import java.util.*;
/*
 * ���ͽ�Ʈ�� �˰��� ���
 * board[][]�� �״�� ���� ���⿡ ���� �ٸ� ���� �����ϴ� ���� �ƴ�
 * �׳� �ּҰ��� �����Ѵ�.
 * �̷��� �ϸ� �ּҰ��̴��� ������ �������� �� ���� ��쿡��
 * �� �������� ���°��� ������ �� �� ���µ� �� ���� �ּҰ��� �ƴ� �ٸ� �������ο� ���� �־����
 * �ּҰ��� �̹� ������־ �ٸ� ������ ��� ���� ����� ������ �߸��� ���� ���� ��
 */
class info1 implements Comparable<info1>{
	int r,c,dir,val;
	
	public info1(int r, int c) {
		this.r = r;
		this.c = c;
	}
	public info1(int r, int c, int dir,int val) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.val = val;
	}
	@Override
	public int compareTo(info1 o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
	 
}

public class Solution4 {
//	static int currentdir = -1;
	static int locrow[] = {0, -1, 1, 0};
	static int loccol[] = {1, 0, 0, -1};
	static PriorityQueue<info1> queue = new PriorityQueue<>();
	//static boolean visited[][];
	static int map[][][];
	static int min = Integer.MAX_VALUE;
	static int val;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int board[][] ={{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		//int board[][] = {{0,0,0},{0,0,0},{0,0,0}};
		//{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		int ans = solution(board);
		System.out.println(ans);
	}
	
	public static int solution(int[][] board) {
		//visited = new boolean[board.length][board[0].length];
		map = new int[board.length][board[0].length][4];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				
			}
		}
		//visited[0][0] = true;
		queue.add(new info1(0,0,-1,0));
	//	for(int i = 0 ; i < boar)
		bfs(board);
		return min;
		
    }
	public static void bfs(int board[][]) {		
		int r, c,dir;
		info1 temp;
		int newr, newc;
		int val;
		int curval;
		
		while(!queue.isEmpty()) {
			temp = queue.poll();
			r = temp.r;
			c = temp.c;
			dir = temp.dir;
			curval = temp.val;
			
			if(r == map.length-1 && c == map[0].length-1) {
				min = Math.min(min, curval);
			}
			
			for(int i =0; i < 4; i++) {
				newr = r + locrow[i];
				newc = c + loccol[i];
						
				val = 0;
				
				if(check(newr, newc) && board[newr][newc] != 1) {
					if(dir==-1)
						val += 100;
					else if(i == dir)
						val += 100;
					else
						val += 600;
					
					if(map[newr][newc][i] == 0 || map[newr][newc][i] >= curval+val) {
						map[newr][newc][i] = curval+val;
						queue.add(new info1(newr, newc, i, curval+val));
					}
					
				}
				
				
			}
		}
			
		
	}
	public static boolean check(int row, int col) {
		if(row >= 0 && row < map.length && col>=0 && col < map[0].length)
			return true;
		return false;
	}
	/*
	public static void dfs(int r, int c, int value,int dir) {
		int newr, newc;
		if(r == map.length-1 && c == map[0].length-1) {
			min = Math.min(min, value);
			return;
		}
		int currentdir;
		
		for(int i =0; i<4; i++) {
			newr = r + locrow[i];
			newc = c + loccol[i];
			
			int val = 0;
			
			if(check(newr, newc) && !visited[newr][newc] && map[newr][newc] != 1) {
				visited[newr][newc] = true;
				val += 100;
				
				if(dir == -1) {
					currentdir = i;
				}
				
				else {
					if(dir != i)
					{
						currentdir = i;
						val += 500;			
					}
					else
						currentdir = i;
				}
				
				dfs(newr,newc,value+val,currentdir);
				
				visited[newr][newc] = false;
				
			}
		}
		
	}
	*/
}
