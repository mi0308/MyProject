import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter; 
import java.util.Arrays; 
import java.util.Comparator; 
import java.util.StringTokenizer; 

/* 
  * Freelancer's work 
  */ 
public class FreeLancer { 
 

 	public static void main(String[] args) throws Exception { 
 		// TODO Auto-generated method stub 
 		int T, N; 
 		work[] ins; 
 		long[] dp; 
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
 		 
 		T = Integer.valueOf(br.readLine()); 
 		for(int ts=1;ts<=T;ts++){ 
 		 
 			N = Integer.valueOf(br.readLine()); 
 			ins = new work[N+1]; 
 			for(int i=1;i<=N;i++){ 
 				StringTokenizer st = new StringTokenizer(br.readLine()); 
 				work a = new work(Integer.valueOf(st.nextToken()),  
 								  Integer.valueOf(st.nextToken()),  
 								  Integer.valueOf(st.nextToken())); 
 				ins[i] = a; 
 			} 
 			 
 			 
 			Arrays.sort(ins, 1, N+1, new Comparator<work>(){ 
 				public int compare(work a, work b){ 
 					return a.e - b.e; 
 				} 
 			}); 
 		 
 			dp = new long[N+1]; 
 			for(int i=1;i<=N;i++){ 
 				/*
 				 * Logic for t
 				 * 
 				 * t : E(t) < S[i] 가 되는 가장 큰 t
 				 */
 				int s=1, e=i-1, t=0; 
 				while(s<=e){ 
 					int m = (s + e) >> 1; 
 					if(ins[m].e < ins[i].s){ 
 						s = m+1; 
 						t = m; 
 					}else{ 
 						e = m-1; 
 					} 
 				} 
 				/*
 				 * i번째 일을 하지 않을 때 -> D[i-1]
 				 * i번째 일을 할 때 -> D[t] + c[i]
 				 * 
 				 * Answer = Max(D[i-1], D[t] + c[i]
 				 */
 				dp[i] = Math.max(dp[i-1],  dp[t] + ins[i].c); 
 			} 
 			 
 			bw.write("#"+ts+" "+dp[N]);
 			bw.newLine();
 			bw.flush();
 		} 
 	} 
 

} 
 

class work{ 
 	public work(int s, int e, int c){ 
 		this.s = s; 
 		this.e = e; 
 		this.c = c; 
 	} 
 	int s, e, c; 
} 
