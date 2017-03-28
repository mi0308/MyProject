import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 유령선
 * BFS
 */
public class Ghostship {

	static int W, H, Sx,Sy, Ex,Ey;
	static int[][] INPUT;
	static int[][] DP;
	static int ANS;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		INPUT = new int[H+1][W+1];
		for(int i=1;i<=H;i++){
			String sn = br.readLine();
			for(int j=1;j<=W;j++){
				char c = sn.charAt(j-1);
				System.out.println("st="+c);
				
				if(c == 'x'){
					INPUT[i][j] = -1;
				}
				if(c == 'o'){
					INPUT[i][j] = 0;
				}
				if(c == 's') {
					Sx = i; Sy = j;
				}	
				if(c == 'e') {
					Ex = i; Ey = j;
				}
			}
		}
		
		DP = new int[H+1][W+1];
		for(int i=1;i<=H;i++){
			for(int j=1;j<=W;j++){
				DP[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		DP[Sx][Sy] = 0;
		q.add(Sx);
		q.add(Sy);
		
		ANS = Integer.MAX_VALUE;
		
		BFS(q);
		
		if(ANS == Integer.MAX_VALUE){
			bw.write("-1");
		}else{
			bw.write(ANS+"");
		}
		bw.newLine();
		bw.flush();
		bw.close();
	}

	static void BFS(Queue<Integer> q){
		
		while(!q.isEmpty()){
			int x = q.poll();
			int y = q.poll();
			
//			for(int i=0;i<4;i++){
//				int ny = y ;
//			}
			
			
			
			
			
			
			
			if(x == Ex && y == Ey){
				if(ANS > INPUT[x][y]){
					ANS = INPUT[x][y];
				}
				return;
			}
			
			if(x+1 <= H && INPUT[x+1][y]==0){
				INPUT[x+1][y] = INPUT[x][y] + 1;
				q.add(x+1);
				q.add(y);
			}
			
			if (x-1 >= 1 && INPUT[x-1][y] == 0 ) {
				INPUT[x-1][y] = INPUT[x][y] + 1;
				q.add(x-1);
				q.add(y);
			}
				  
			if (y+1 <= W && INPUT[x][y+1] == 0) {
				INPUT[x][y+1] = INPUT[x][y] + 1;
				q.add(x);
				q.add(y+1);
			}
				  
			if (y-1 >= 1 && INPUT[x][y-1] == 0 ) {
				INPUT[x][y-1] = INPUT[x][y] + 1;
				q.add(x);
				q.add(y-1);
			}
		}
	}
}
