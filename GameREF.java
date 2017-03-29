import java.io.*;
import java.util.*;
  
public class source {
    static int[] yy = {-1, 0, 1, 0}, xx = {0, 1, 0, -1};
    static int N, M, K;
    static int[][] A, G;
    static ArrayList<Integer>[] con;
     
    static void color(int y, int x) {
        for (int dir=0;dir<4;dir++){
            int ny = y + yy[dir], nx = x + xx[dir];
            if (ny < 1 || ny > N || nx < 1 || nx > M || A[ny][nx] != A[y][x] || G[ny][nx] != 0) continue;
            G[ny][nx] = G[y][x];
            color(ny, nx);
        }
    }
     
    static int bfs(int st) {
        int[] D = new int[K+1];
        for (int i=1;i<=K;i++) D[i] = Integer.MAX_VALUE;
        Queue <Integer> que = new LinkedList<Integer>();
        que.add(st); D[st] = 0;
        while (!que.isEmpty()){
            int q = que.poll();
            for (int t: con[q]){
                if (D[t] < Integer.MAX_VALUE) continue;
                D[t] = D[q]+1; que.add(t);
            }
        }
        int ret = 0;
        for (int i=1;i<=K;i++) ret = Math.max(ret, D[i]);
        return ret;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1][M+1];
        for (int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=M;j++) A[i][j] = Integer.parseInt(st.nextToken());
        }
         
        G = new int[N+1][M+1];
        for (int i=1;i<=N;i++) for (int j=1;j<=M;j++) if (G[i][j] == 0){
            G[i][j] = ++K;
            color(i, j);
        }
         
        con = new ArrayList[K+1];
        for (int i=1;i<=K;i++) con[i] = new ArrayList<Integer>();
        for (int i=1;i<=N;i++) for (int j=1;j<=M;j++){
            for (int dir=0;dir<4;dir++){
                int y = i + yy[dir], x = j + xx[dir];
                if (y < 1 || y > N || x < 1 || x > M || A[y][x] == A[i][j]) continue;
                con[G[i][j]].add(G[y][x]);
            }
        }
         
        int ans = Integer.MAX_VALUE;
        for (int i=1;i<=K;i++) ans = Math.min(ans, bfs(i));
        System.out.println(ans);
    }
}
