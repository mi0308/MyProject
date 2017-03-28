import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 군사 도로망
 * MST : Minimum Spanning Tree
 * Union & Find
 * Kruskal Algorithm
 */
public class MilitaryRoad {

	static int N, M, K;
	static ArrayList<Edge1> edges = new ArrayList<>();
	static int[] PAR = new int[100001];
	static long ANS = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge1(a, b, -c));
			ANS += c;
		}
		
		for(int i=1;i<=K;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge1(a, b, c));
		}
		
		Collections.sort(edges, new Comparator<Edge1>(){
			public int compare(Edge1 a, Edge1 b){
				return a.c - b.c;
			}
		});
		
		for(int i=1;i<=N;i++){
			PAR[i] = i;
		}
		
		for(int i=0;i<edges.size();i++){
			
			Edge1 e = edges.get(i);
			
			int bcost=0;
			if(i>0){
				bcost = edges.get(i-1).c;
			}
			
			if(i==0 || bcost != e.c){
				for(int j=1;j<edges.size();j++){
					Edge1 e1 = edges.get(j);
					if(e.c != e1.c){
						break;
					}
					if(find(e1.a) != find(e1.b)) {
						e1.status = true;
					}
				}
			}
			if(union(e.a, e.b)){
				ANS += e.c;
				e.in_mst = true;
			}
		}
		
		boolean chk=true;
		for(Edge1 e : edges) {
			if(e.status && !e.in_mst){
				chk=false;
			}
		}
		
		String fg="unique";
		if(!chk){
			fg = "not unique";
		}
		bw.write(ANS+" "+fg);
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
	static int find(int n){
		if(PAR[n] == n) return n;
		return PAR[n] = find(PAR[n]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		
		PAR[b] = a;
		return true;
	}

}

class Edge1{
	int a, b, c;
	boolean status, in_mst;
	public Edge1(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		status = false;
		in_mst = false;
	}
}
