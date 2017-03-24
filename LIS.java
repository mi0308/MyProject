import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LIS {

	static int N;
	static int RESULT;
	static int[] A;
	static int[] LIS;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		N = Integer.parseInt(str);
		A = new int[N+1];
		LIS = new int[N+1];
		
		str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			LIS[i] = Integer.MAX_VALUE;
		}
		
		br.close();
		
		solution();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(RESULT+"");
		bw.flush();
		bw.close();
	}
	
	static void solution() {
		
		LIS[0] = Integer.MIN_VALUE;
		int offset = 1;
		LIS[1] = A[1];
		
		for(int i=2; i<=N; i++) {
			int v = A[i];
			
			if( v > LIS[offset] ) {
				offset++;
				LIS[offset] = v;
				continue;
			}
			
			int s=0, e=offset;
			int j=offset;
			
			
			while(true) {
				if( LIS[j-1] < v && v <= LIS[j] ) {
					LIS[j] = v;
					break;
				}

				if( LIS[j] < v ) {
					s = j;
				} else {
					e = j;
				}
				
				j = (s+e)/2;
			}
			
		}
		
		RESULT = offset;
	}

}
