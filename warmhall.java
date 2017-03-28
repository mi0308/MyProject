import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 웜홀
 * 
 * Bellman Ford Algorithm 응용
 */
public class Warmhall {

	static int N, M, W;
	static ArrayList<Edge> EDGE;
	static int[] DIST;
	static String ANS;
	static boolean chk = true;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int ts = 1;ts<=T;ts++){
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());			
			
			EDGE = new ArrayList<>();
			for(int i=1;i<=M;i++){
				st        = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end   = Integer.parseInt(st.nextToken());
				int time  = Integer.parseInt(st.nextToken());
				
				EDGE.add(new Edge(start, end, time));
				EDGE.add(new Edge(end, start, time));
			}
			
			for(int i=1;i<=W;i++){
				st        = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end   = Integer.parseInt(st.nextToken());
				int time  = Integer.parseInt(st.nextToken());
				
				EDGE.add(new Edge(start, end, -time));
			}
			
			if(chk){
				System.out.println("road");
				for(int i=1;i<=M;i++){
					int start = EDGE.get(i).m;
					int end   = EDGE.get(i).n;
					int time  = EDGE.get(i).w;
					System.out.println("start="+start+", end="+end+", time="+time);
				}
				
				System.out.println("warmholl");
				for(int i=1;i<=W;i++){
					int start = EDGE.get(i).m;
					int end   = EDGE.get(i).n;
					int time  = EDGE.get(i).w;
					System.out.println("start="+start+", end="+end+", time="+time);
				}
			}
			
			
			DIST = new int[N+1];
			boolean flag = false;
			for(int i=1;i<=N;i++){
				boolean chk = false;
				for(Edge e : EDGE){
					if(DIST[e.m] > DIST[e.n] + e.w){
						DIST[e.m] = DIST[e.n] + e.w;
						chk = true;
					}
				}
				if(!chk) {
					flag = true;
					break;
				}
			}
			
			ANS = flag ? "NO" : "YES";
			bw.write(ANS+"");
			bw.newLine();			
		}
		bw.flush();
		bw.close();
	}

}

class Edge{
	public Edge(int n, int m, int w){
		this.n = n;
		this.m = m;
		this.w = w;
	}
	int n, m, w;
}
