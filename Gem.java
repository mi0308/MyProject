import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 보석
 */
public class Gem {

	static int N, K;
	static long RESULT;
	static PriorityQueue<Integer[]> JEWERLY;
	static int[] BAG;
	static boolean[] USED_BAG;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BAG = new int[K+1];
		USED_BAG = new boolean[K+1];
		JEWERLY = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] arg0, Integer[] arg1) {
				if( arg0[1]==arg1[1] ) {
					return arg0[0]-arg1[0];
				}
				return arg1[1] - arg0[1];
			}
		});
		
		for(int i=1; i<=N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int mi = Integer.parseInt(st.nextToken());
			int vi = Integer.parseInt(st.nextToken());
			
			JEWERLY.add(new Integer[]{mi, vi});
		}
		
		for(int i=1; i<=K; i++) {
			str = br.readLine();
			
			int ci = Integer.parseInt(str);
			BAG[i] = ci;
		}
		
		br.close();
		
		solution();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(RESULT+"");
		bw.flush();
		bw.close();
	}
	
	static void solution() {
		
		Arrays.sort(BAG);
		BAG[0] = Integer.MAX_VALUE;
		
		int bag_cnt = K;
		while( bag_cnt > 0 && !JEWERLY.isEmpty() ) {
			Integer[] j = JEWERLY.poll();
			
			int mi = j[0];
			int vi = j[1];
			
			int tmpBag = 0;
			for(int i=1; i<=K; i++) {
				if( BAG[i] >= mi && !USED_BAG[i] ) {
					tmpBag = i;
					break;
				}
			}
			
			if( tmpBag == 0 ) {
				continue;
			} else {
				bag_cnt--;
				RESULT += vi;
				USED_BAG[tmpBag] = true;
			}
		}
		
	}

}
