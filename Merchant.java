import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 상인
 * Rooted Tree
 * LCA : Lowest Common Ancestor
 * Sparse Table
 */
public class Merchant {

	static int N;
	static ArrayList<Integer>[] EDGE;
	static int[] DEPTH; 
	static int[][] PARENT;
	static long ANS;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		EDGE = new ArrayList[N+1];
		for(int i=1;i<=N;i++){
			EDGE[i] = new ArrayList<>();
		}
		
		for(int i=1;i<N;i++){
			StringTokenizer st = new  StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			
			EDGE[start].add(end);
			EDGE[end].add(start);
		}
		
		DEPTH  = new int[N+1];
		// 2^K 번째 조상은 N=100000 인 경우 2^17의 범위 내에서 찾을 수 있으므로
		// Depth 17로 하는 Parent 배열 선언
		PARENT = new int[N+1][17];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		while(!q.isEmpty()){
			int x = q.poll();
			for(int i : EDGE[x]){
				if(PARENT[x][0] != i){
					PARENT[i][0] = x;
					DEPTH[i]     = DEPTH[x]+1;
					q.add(i);
				}
			}
		}
		for(int i=1;i<17;i++){
			for(int j=1;j<=N;j++){
				PARENT[j][i] = PARENT[PARENT[j][i-1]][i-1];
			}
		}
		
		ANS = 0;
		for(int i=1;i<N;i++){
			int j = i+1;
			int k = LCA(i, j);
			
			ANS += DEPTH[i] + DEPTH[j] - 2*DEPTH[k];
		}
		bw.write(ANS+"");
		bw.newLine();
		bw.flush();
		bw.close();
	}

	/*
	 * x, y 의  Lowest Common Ancestor 찾기
	 */
	static int LCA(int x, int y){
		int ret=0;
		
		if(DEPTH[x] < DEPTH[y]) {
			return LCA(y, x);
		}
		
		for(int i=0;i<17;i++){
			int c = (DEPTH[y]-DEPTH[x])&(1<<i);
			if(c > 0) {
				x = PARENT[x][i];
			}
		}
		
		if(x == y) return x;
		for(int i=17;i-- > 0;){
			if(PARENT[x][i] != PARENT[y][i]){
				x = PARENT[x][i];
				y = PARENT[y][i];
			}
		}
		
		ret = PARENT[x][0];
		
		return ret;
	}
}
