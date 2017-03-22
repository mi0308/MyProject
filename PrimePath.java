import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 소수 경로
 * 4자리 소수 -> 4자리 소수
 */
public class PrimePath {

	static boolean[] is_prime;
	static int[] dist;
	static int N=10000;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		is_prime = new boolean[N];
		for(int i=1001;i<N;i++){
			is_prime[i] = false;
			if(prime(i)){
				is_prime[i] = true;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		int A, B;

		dist = new int[N];
		for(int ts = 0 ; ts<T;ts++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
            dist = new int[N];
            for (int i=0;i<10000;i++) {
            	dist[i] = Integer.MAX_VALUE;
            }
			
			bfs(A);
			
			int ans = dist[B];
			
			bw.write(ans+"");
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
	
	static void bfs(int s){
		Queue<Integer> q = new LinkedList<Integer>();
		
        q.add(s); 
        dist[s] = 0;
        while (!q.isEmpty()){
            int x = q.poll();
            for (int b=1;b<10000;b*=10){
                for (int d=0;d<10;d++){
                    int v = x / b / 10 * b * 10 + x % b + b * d;
                    if (!is_prime[v] || dist[v] < Integer.MAX_VALUE) {
                    	continue;
                    }
                    dist[v] = dist[x]+1;
                    q.add(v);
                }
            }
        }
	}

	/*
	 * 소수 판별
	 */
	static boolean prime(int x) {
		for (int i=2;i*i<=x;i++) {
			if (x%i==0) {
		    	return false;
		    }
		}
		return true;
	}
}
