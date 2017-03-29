import java.io.*;
import java.util.*;
 
public class source {
    static int[] yy = {-1, 0, 1, 0}, xx = {0, 1, 0, -1};
    static int N, M, sy, sx, ey, ex;
    static char[][] A;
    static int[][] D;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new char[N+1][M+1];
        for (int i=1;i<=N;i++){
            String s = br.readLine();
            for (int j=1;j<=M;j++){
                A[i][j] = s.charAt(j-1);
                if (A[i][j] == &#39;S&#39;){ sy = i; sx = j; }
                if (A[i][j] == &#39;E&#39;){ ey = i; ex = j; }
            }
        }
        D = new int[N+1][M+1];
        for (int i=1;i<=N;i++) for (int j=1;j<=M;j++) D[i][j] = Integer.MAX_VALUE;
        Queue<Integer> que = new LinkedList<>();
        D[sy][sx] = 0; que.add(sy); que.add(sx);
        while (!que.isEmpty()){
            int y = que.poll(), x = que.poll();
            for (int dir=0;dir<4;dir++){
                int ny = y + yy[dir], nx = x + xx[dir];
                if (ny < 1 || ny > N || nx < 1 || nx > M || A[ny][nx] == &#39;X&#39; || D[ny][nx] < Integer.MAX_VALUE) continue;
                D[ny][nx] = D[y][x] + 1;
                que.add(ny); que.add(nx);
            }
        }
        System.out.println(D[ey][ex] < Integer.MAX_VALUE ? D[ey][ex] : -1);
    }
}
