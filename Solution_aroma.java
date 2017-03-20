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


public class Solution_aroma {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.valueOf(br.readLine());
		ArrayList<Tri> lst;
		for(int ts = 1;ts<=T;ts++){
			int N = Integer.valueOf(br.readLine());
			lst = new ArrayList<Tri>();

			for(int i=0;i<N;i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());

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
			
			int ans = 0;
			
			ans = lst.get(0).getS();
			System.out.println("ans="+ans);
			/*
			 * 	int ret = dfs(16, n-1, lst)
			 *  if(lst.get(0).getA()>ret){
			 *  	ans -= (list.get(0).getA()-ret);	
			 *  }
			 *  
			 *  ans = Math.max(ans, dfs(16, n-1, lst);
			 *  
			 *  
			 *  
			 */			
			
			bw.write(ans+"");
			bw.newLine();
			bw.flush();
		}
	}
	
	static void dfs(int N, int idx, int[] list){
		if(idx==0){
			
		}
		
		
	}
	
	public static void print(ArrayList<Tri> list) {
		for (Tri each : list) {
			System.out.printf(" %5d   %5s   %5s", each.getS(), each.getA(), each.getB());
			System.out.println();
//			System.out.println(each.getS()+":"+each.getA()+","+each.getB());
		}
	}

}

class Tri {
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
