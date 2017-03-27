import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 최단경로
 * Dijkstra
 * MinHeap 사용 : PriorityQueue
 */

public class MaxShortdist {

	static int N, M;
	static ArrayList<Integer>[] con, conv;
	static int[] DP;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		con  = new ArrayList[N+1];
		conv = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++){
			con[i] = new ArrayList<>();
			conv[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=M;i++){
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			con[a].add(b); conv[a].add(c);
			con[b].add(a); conv[b].add(c);
			
		}
		
		DP = new int[N+1];
		for(int i=1;i<=N;i++){
			DP[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(10, new Comparator<int[]>(){
				public int compare(int[] a, int[] b){
					return a[0] - b[0];
				}
		});
		
		DP[1] = 0;
		q.add(new int[]{0, 1});
		
		while(!q.isEmpty()){
			int c = q.peek()[1];
			int d = q.peek()[0];
			
			q.poll();
			
			if(DP[c] != d) continue;
			
			for(int i=0;i<con[c].size();i++){
				int t = con[c].get(i);
				int v = conv[c].get(i);
				
				if(DP[t] > DP[c] + v){
					DP[t] = DP[c] + v;
					q.add(new int[]{DP[t], t});
				}
			}
			
		}
		
		int  ans = (DP[N] < Integer.MAX_VALUE) ? DP[N] : -1;
		System.out.println(ans);
	}

}
