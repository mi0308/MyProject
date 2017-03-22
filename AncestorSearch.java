import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 조상찾기
 * 
 * Rooted Tree
 */
public class AncestorSearch {

	static boolean[]  visit;
	static int[] S, E;
	static ArrayList<Integer>[] childs;
	static int cnt;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// number of node
		int N = Integer.parseInt(st.nextToken());
		
		// Root number
		int R = Integer.parseInt(st.nextToken());
				
		// number of Question
		int Q = Integer.parseInt(st.nextToken());
		
		System.out.println("N="+N+", R="+R+", Q="+Q);
		
		int[] P = new int[N+1];
		childs = new ArrayList[N+1];
		for(int i=1;i<=N;i++){
			ArrayList<Integer> lst = new ArrayList<Integer>();
			childs[i] = lst;
		}
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			P[i] = Integer.parseInt(st.nextToken());
//			System.out.println("pi="+P[i]+", i="+i+", R="+R+", child.len="+childs.length);
			
			if(i != R) {
				if(childs[P[i]].isEmpty()){
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(i);
					childs[P[i]] = list;
				}else{
					childs[P[i]].add(i);
				}
			}
		}
		
		for(int i=1;i<=N;i++){
			System.out.print("i="+i+", childsi.size="+childs[i].size());
			for(int j=0;j<childs[i].size();j++){
				System.out.print(", j="+j+", childs="+childs[i].get(j)+" ");
			}
			System.out.println();;
		}
		
		
		visit = new boolean[N];
		S = new int[N];
		E = new int[N];
		cnt = 0;
		for(int i=0;i<Q;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			System.out.println("x="+x+", y="+y);
			System.out.println(childs[x].contains(y));
			/*
			if(childs[x].contains(y)){
				System.out.println("x="+x+", y="+y);
				System.out.println("YES");
//				bw.write("YES");
			}else{
				System.out.println("x="+x+", y="+y);
				System.out.println("NO");
//				bw.write("NO");
			}
			*/
			dfs(R);
			
			bw.write("");
			bw.newLine();
			bw.flush();
			
		}
	}

	static void dfs(int x){
		visit[x] = true;
		S[x] = cnt++;
		
		for(int i=0;i<childs[x].size();i++){
			if(visit[i]) {
				continue;
			}
			
		}
		E[x] = cnt++;
	}
/*
   [DFS Numbering]
   
   visit[], S[], E[], cnt=0
void dfs(int x){
  visit[x] = true
  S[x] = ++cnt
  for all y : connected to x
    if (visit[y]) continue
    dfs(y)
  E[x] = ++cnt
}  
dfs(S)

x가 y의 조상?  ===>  S[x] <= S[y] <= E[x] 인 것과 동치

*/
}
