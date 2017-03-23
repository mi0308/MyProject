import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * Sliding Windows
 * Deque
 */
public class SlidingWindow {

	static int N, K;
	static int[] INS;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        INS = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
        	INS[i] = Integer.parseInt(st.nextToken());
        }
        
        search();
	}

	
	static void search() throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Deque<Integer> mn = new ArrayDeque<Integer>();
        Deque<Integer> mx = new ArrayDeque<Integer>();
        long sum = 0;
        for (int i=1;i<=N;i++){
            while (!mn.isEmpty() && INS[mn.getLast()] >= INS[i]) mn.pollLast();
            while (!mx.isEmpty() && INS[mx.getLast()] <= INS[i]) mx.pollLast();
            mn.addLast(i);
            mx.addLast(i);
            sum += INS[i];
            if (i > K) sum -= INS[i-K];
            while (mn.getFirst() <= i-K) mn.pollFirst();
            while (mx.getFirst() <= i-K) mx.pollFirst();
            if (i >= K) {
                bw.write(INS[mn.getFirst()] + " " + INS[mx.getFirst()] + " " + sum + "\n");
            }
        }
        bw.flush();
        bw.close();
	}
}
