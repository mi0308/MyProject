import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 색칠 공부
 * 
 */
public class Paintingclass {

	static int N, K, ANS;
	static int[] INS, INDEX;
	static long[] DP;
	static boolean[] VISIT;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		INS = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			INS[i] = Integer.parseInt(st.nextToken());
		}
		
		ANS = 0;
		
		pass();
		
		bw.write(ANS+"");
		bw.newLine();
		bw.flush();
		bw.close();
	}

	static void pass(){
		int MOD=0;
		PriorityQueue<Integer> Q = new PriorityQueue<>();
		
		for(int i=1;i<=N;i++){
			if(INDEX[i] ==0) {
				Q.add(i);
			}
		}
		
		while(!Q.isEmpty()){
			int x = Q.poll();
			VISIT[x] = true;
			ANS = (ANS*(K-1)) % MOD; 
			
		}
	}
}
