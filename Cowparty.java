import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * Cow party
 * Dijkstra Algorithm
 */
public class Cowparty {

	static int N, M, X;
	static int[][] IN;
	static int[][] rIN;
	static int[] DP;
	static int[] rDP;
	static int ANS;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		IN = new int[N+1][N+1];
		rIN = new int[N+1][N+1];
		for(int i=1; i<=N;i++){
			for(int j=1; j<=N;j++){
				
				IN[i][j] = rIN[i][j] = ( (i == j) ? 0 : Integer.MAX_VALUE);
				/*
				int x = ( (i == j) ? 0 : Integer.MAX_VALUE);
				rIN[i][j] = x;
				IN[i][j]  = x;
				*/
			}
		}
		
		for(int i=1;i<=M;i++){
			st        = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			int time  = Integer.parseInt(st.nextToken());
			
			IN[start][end]  = Math.min(IN[start][end], time);
			rIN[end][start] = Math.min(rIN[end][start], time);
		}
		
		
		DP = new int[N+1];
		rDP = new int[N+1];
		
		// party 장 갈 때
		process(X, IN, DP);
		// party 장 올 때
		process(X, rIN, rDP);
		
		ANS = 0;
		for(int i=1;i<=N;i++){
			ANS = Math.max(ANS, DP[i] + rDP[i]);
		}
		bw.write(ANS+"");
		bw.newLine();
		bw.flush();
		bw.close();
	}

	/*
	 * Dijkstra Algorithm
	 */
	static void process(int s, int[][] list, int[] dist){
		for(int i=0;i<=N;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;
		boolean[] visit = new boolean[N+1];
		
		for(int i=1;i<=N;i++){
			int t=0;
			for(int j=1;j<=N;j++){
				if(!visit[j] && dist[t]  > dist[j]){
					t = j;
				}
			}
			visit[t] = true;
			for(int j=1;j<=N;j++){
				if(list[t][j] < Integer.MAX_VALUE){
					dist[j] = Math.min(dist[j], dist[t] + list[t][j]);
				}
			}
		}
		
	}
}
