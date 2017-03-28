import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * Picnic
 * BFS
 */
public class Picnic {

	static int K, N, M, ANS;
	static int[] sNODE = new int[101];
	static int[] eNODE = new int[1001];
	static int[] VISIT = new int[1001];
	static ArrayList<Integer>[] EDGE = new ArrayList[1001];
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=K;i++){
			sNODE[i] = Integer.parseInt(br.readLine()); 
		}
		
		for(int i=1;i<=N;i++){
			EDGE[i] = new ArrayList<Integer>(); 
		}
		
		for(int i=1;i<=M;i++){
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			EDGE[s].add(e);
		}

		int start, n;
		for(int i=1;i<=K;i++){
			for(int k=1;k<=N;k++){
				VISIT[k] = 0;
			}
			
			pq.clear();
			
			start = sNODE[i];
			pq.offer(start);
			VISIT[start] = 1;
			eNODE[start]++;
			while(!pq.isEmpty()){
				n = pq.poll();
				for(int next : EDGE[n]){
					if(!pq.contains(next) && VISIT[next] == 0){
						pq.offer(next);
						VISIT[next] = 1;
						eNODE[next]++;
					}
				}
			}
		}
		
		ANS = 0;
		for(int i=1;i<=N;i++){
			if(eNODE[i] == K){
				ANS++;
			}
		}
		
		bw.write(ANS+"");
		bw.newLine();
		bw.flush();
		bw.close();
	}

}
