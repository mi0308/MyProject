//군사도로망 //최종 소스 코드 
import java.util.*;
import java.io.*;
 
class milroad {
    public Edge5(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        mark = in_mst = false;
    }
 
    int a, b, c;
    boolean mark, in_mst;
}
 
public class day6_militaryLoad {
    static int N, M, K;
    static int[] par;
    static ArrayList<Edge5> edges;
     
    static int find(int n) {
        if (par[n] == n) return n;
        return par[n] = find(par[n]);
    }
     
    static boolean union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        par[b] = a;
        return true;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        long ans = 0;
        for (int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge5(a, b, -c));
            ans += c;
        }
        for (int i=1;i<=K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge5(a, b, c));
        }
        Collections.sort(edges, new Comparator<Edge5>() {
            public int compare(Edge5 a, Edge5 b) {
                return a.c - b.c;
            }
        });
         
        par = new int[N+1];
        for (int i=1;i<=N;i++) par[i] = i;
        for (int i=0;i<edges.size();i++){
            Edge5 e = edges.get(i);
            if (i == 0 || edges.get(i-1).c != e.c){
                for (int j=i;j<edges.size();j++){
                    Edge5 t = edges.get(j);
                    if (e.c != t.c) break;
                    if (find(t.a) != find(t.b)) t.mark = true;
                }
            }
            if (union(e.a, e.b)){
                ans += e.c;
                e.in_mst = true;
            }
        }
         
        boolean unique = true;
        for (Edge5 e: edges) if (e.mark && !e.in_mst) unique = false;
         
        System.out.println(ans + " " + (unique ? "unique" : "not unique"));
    }
}
