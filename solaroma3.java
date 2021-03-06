import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Aroma {
	

	public static void main(String[] args) throws Exception{ 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    
		int T = Integer.valueOf(br.readLine());    
		int[][] ins;
		int[] tmp;  
		ArrayList<Perf> lst;  
		for(int ts = 1;ts<=T;ts++){   
			int N = Integer.valueOf(br.readLine());   
			lst = new ArrayList<Perf>();   
			for(int i=0;i<N;i++){    
				StringTokenizer st = new StringTokenizer(br.readLine());    
				int a = Integer.valueOf(st.nextToken());    
				int b = Integer.valueOf(st.nextToken());    
				Perf t = new Perf(a, b);    
				lst.add(t);
			}   
			
			Comparator<Perf> sort = new Comparator<Perf>(){    
				public int compare(Perf o1, Perf o2){     
				return o1.getS() < o2.getS()? -1 : (o1.getS() < o2.getS()?1:0);    
				}};   
				
			Collections.sort(lst, sort);
			print(lst);
			
			int len = lst.get(N-1).s;   
			int[] dp = new int[len];      
			
			for(int i=0;i<N;i++){
				//    System.out.println("i="+i+", j="+lst.get(i).a);    
				for(int j=lst.get(i).a;j>0;j--){     

					if(i==0){      
						dp[i] = lst.get(i).b;     
					}else{      
						if( lst.get(i-1).b < lst.get(i).a) {       
							dp[j] = dp[j-1]+lst.get(i).b;      
						}else{             
						}     
					}
				//     System.out.println("i="+i+",j="+j+", dp[j]="+dp[j]);    
				}   
			}      

			int ans = Integer.MIN_VALUE;   
			for(int i=0;i<dp.length;i++){    
				if(dp[i] > ans)	ans = dp[i];    
			}   
			ans = lst.get(N-1).s;         
			bw.write("#"+ts+" "+ans);   
			bw.newLine();   
			bw.flush();  

		}    
	}
		
		
	static boolean isSubsetSum(int set[], int n, int sum)    {       
			// Base Cases       
			if (sum == 0)  return true;       
			if (n == 0 && sum != 0) return false;             
			if (set[n-1] > sum) return isSubsetSum(set, n-1, sum);             
			return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]);    
	} 
	static boolean dfs(ArrayList<Perf> arr, int n, int sum){  
		if (sum == 0)  return true;        
		if (n == 0 && sum != 0) return false;               
		if (arr.get(n-1).getS() > sum) return dfs(arr, n-1, sum);               
		return dfs(arr, n-1, sum) || dfs(arr, n-1, sum-arr.get(n-1).getS());   
	}
	
	public static void print(ArrayList<Perf> list) {  
		for (Perf each : list)    
		System.out.println(each.getS()+":"+each.getA()+","+each.getB()); 
	}
}
	
class Perf {
		int a, b, s;
		public int getA() {  return a; } 
		public void setA(int a) {  this.a = a; } 
		public int getB() {  return b; } 
		public void setB(int b) {  this.b = b; } 
		public int getS() {  return s; } 
		public void setS(int s) {  this.s = s; } 
		public Perf(int A, int B){  this.a = A;  this.b = B;  this.s = A + B; } 
}
