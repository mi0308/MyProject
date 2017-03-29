import java.io.*;
 
public class source {
    static final int MOD = (int)1e7 + 3;
    static int N, M;
    static int[] A;
    static int[][] D;
     
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        for (int i=1;i<=N;i++){
            A[i] = Integer.parseInt(br.readLine());
            M = Math.max(M, A[i]);
        }
        D = new int[N+1][M+1];
        D[0][0] = 1;
        for (int i=0;i<N;i++) for (int j=0;j<=M;j++) if (D[i][j] > 0){
            // i+1번째 수를 선택하는 경우
            int g = gcd(j, A[i+1]);
            D[i+1][g] = (D[i+1][g] + D[i][j])%MOD;
            // i+1번째 수를 선택하지 않는 경우
            D[i+1][j] = (D[i+1][j] + D[i][j])%MOD;
        }
        System.out.println(D[N][1]);
    }
}
