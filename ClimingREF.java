import java.io.*;
import java.util.*;
 
public class source {
    static int[] yy = {-1, 0, 1, 0}, xx = {0, 1, 0, -1};
    static int N;
    static int[][] A;
     
    static boolean proc(int diff) {
        for (int mn=A[1][1];mn>=0;mn--){
            int mx = mn+diff;
            if (A[1][1] > mx) break;
            boolean[][] vis = new boolean[N+1][N+1];
            Queue<Integer> que = new LinkedList<Integer>();
            vis[1][1] = true; que.add(1); que.add(1);
            while (!que.isEmpty()){
                int y = que.poll(), x = que.poll();
                for (int dir=0;dir<4;dir++){
                    int ny = y + yy[dir], nx = x + xx[dir];
                    if (ny < 1 || ny > N || nx < 1 || nx > N || vis[ny][nx] || A[ny][nx] < mn || A[ny][nx] > mx) continue;
                    vis[ny][nx] = true;
                    que.add(ny); que.add(nx);
                }
            }
            if (vis[N][N]) return true;
        }
        return false;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1][N+1];
        for (int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) A[i][j] = Integer.parseInt(st.nextToken());
        }
        int s = 0, e = 200, ans = 0;
        while (s <= e){
            int m = s+e >> 1;
            if (proc(m)){
                e = m-1;
                ans = m;
            }else s = m+1;
        }
        System.out.println(ans);
    }
}
