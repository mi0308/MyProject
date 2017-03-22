import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Solution_aroma {

	static long[] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.valueOf(br.readLine());

		ArrayList<Tri> lst;
		Tri[] ins;
		for(int ts = 1;ts<=T;ts++){
			int N = Integer.valueOf(br.readLine());
			lst = new ArrayList<Tri>();
			ins = new Tri[N+1];
			for(int i=1;i<=N;i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				Tri ti = new Tri(a, b);
				ins[i] = ti;
				
				Tri t = new Tri(a, b);
				lst.add(t);
//				System.out.println("a="+a+", b="+b+", tmp="+tmp[i]);
			}

//			System.out.println("before sort");
//			print(lst);
			
			Comparator<Tri> sort = new Comparator<Tri>(){
				public int compare(Tri o1, Tri o2){
					return o1.getS() > o2.getS()? -1 : (o1.getS() < o2.getS()?1:0);
				}
			};
			Collections.sort(lst, sort);
			
//			System.out.println("after sort");
			print(lst);
			
			dp = new long[lst.get(0).s+1];
			
			/*
			 * 1. valid time + life time sort by ascend
			 * 2. 1-dimension array (size = max(valid time + life time)
			 * 3. dfs execute
			 * 
			 * for(i : 0 ~ N (sorted data) {
			 * 		for(j : 선택된 데이터의 유통기간 ~ 0) {
			 * 		
			 * 			dp[j] 가  이전 조합들 중 유효한 조합이면,
			 *          dp[j + 선택된 데이터의 지속시간] 도 가능
			 * 
			 * 		}
			 * }
			 * 
			 * 4. dp 배열 뒤에서부터 탐색하면서 가장 높은 index를 출력
			 */
			
			for(int i=1;i<=lst.get(0).s;i++){
				for(int j=lst.get(i-1).a;j>=0;j--){
					System.out.println("i="+i+", j="+j);
					
					
					dp[i] = Math.max(dp[j-1],  dp[j-1] + lst.get(i).b);
				}
			}
			
			
			/*
			 * long ans = dp[N];
 			for(int i=0;i<N;i++){ 

//				Logic for t
//				t : E(t) < S[i] 가 되는 가장 큰 t

 				int s=1, e=i-1, t=0; 
 				while(s<=e){ 
 					int m = (s + e) >> 1; 
 				
 				System.out.println("i="+i+", s="+s+", e="+e+", m="+m);
 					if(lst.get(m).b < lst.get(i).a){
 						s = m+1; 
 						t = m; 
 					}else{ 
 						e = m-1; 
 					} 
 				} 
 				
 				 // i번째 일을 하지 않을 때 -> D[i-1]
 				 // i번째 일을 할 때 -> D[t] + c[i]
 				 // Answer = Max(D[i-1], D[t] + c[i])
 				//  dp[i] = Math.max(dp[i-1],  dp[i-1] + lst.get(i).b);
				// 	dp[i] = Math.max(dp[i-1],  dp[t] + lst.get(i).b); 
 			}
 			*/
			
		    long ans = dp[lst.get(0).s];
		    
			bw.write("ans="+ans);
			bw.newLine();
			bw.flush();
			bw.close();
			
			
		}
	}
	
	static void dfs(){
		
	}
	
	public static void print(ArrayList<Tri> list) {
		for (Tri each : list) 
			System.out.println(each.getS()+":"+each.getA()+","+each.getB());
	}

}

class Tri {
	// a : valid time
	// b : life time
	// s : a + b
	int a, b, s;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	public Tri(int A, int B){
		this.a = A;
		this.b = B;
		this.s = A + B;
	}
}
