import java.io.*;
import java.util.*;


/*
 * Warf
 * 
 */
public class Warf {

	static long N; // 행성 개수 [1 ~ 100000]
	static long M; // 워프장치 개수[1 ~ 500000]
	static long[] DP;
	static long Min;
	static boolean chk;
	static PriorityQueue<Long> q = new PriorityQueue<Long>();
	static ArrayList<Long> arrlist [];//워프장치 정보

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		DP = new long[3];
		
		arrlist = new ArrayList[(int) (N+1)];
		for (int i = 0; i < N+1; i++) {
			arrlist[i] = new ArrayList<Long>();
		}
		Min = 0;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			long from = Long.parseLong(st.nextToken());
			int    to = Integer.parseInt(st.nextToken());
			long  len = Long.parseLong(st.nextToken());

            if(to==N){
            	chk=true;
            }
			arrlist[to].add(len);
            
		}
	
		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				Min = 0;
				DP[i] = 0;
			} else {
				for (long j : arrlist[i]) {
					q.add(j);
				}
				long newMin = q.peek();
				Min = newMin;
				q.clear();

			}
			long temp = DP[2];
			DP[1] = DP[2];
			long ntemp = temp + Min;
			DP[2] = ntemp;

		}

		if(chk) {
			System.out.println(DP[2]);
		}else{
			System.out.println(-1);
		}
	}

}
