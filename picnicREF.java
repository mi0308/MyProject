import java.io.*;
import java.util.*;
 
public class source {
    static int N, M, K;
    static int[] P;
    static ArrayList<Integer>[] con;
    static boolean[][] D;
     
    static void bfs(int s, boolean[] vis) {
        Queue<Integer> que = new LinkedList<>();
        vis[s] = true; que.add(s);
        while (!que.isEmpty()){
            int q = que.poll();
            for (int t: con[q]){
                if (vis[t]) continue;
                vis[t] = true; que.add(t);
            }
        }
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = new int[K+1];
        for (int i=1;i<=K;i++) P[i] = Integer.parseInt(br.readLine());
        con = new ArrayList[N+1];
        for (int i=1;i<=N;i++) con[i] = new ArrayList<>();
        for (int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            con[a].add(b);
        }
        D = new boolean[K+1][N+1];
        for (int i=1;i<=K;i++) bfs(P[i], D[i]);
        int ans = 0;
        for (int i=1;i<=N;i++){
            boolean sw = true;
            for (int j=1;j<=K;j++) if (!D[j][i]){
                sw = false;
                break;
            }
            if (sw) ans++;
        }
        System.out.println(ans);
    }
}
