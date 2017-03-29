import java.io.*;
import java.util.*;
 
public class source {
    static int N, K;
    static long[] A, B, C;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new long[K+1]; B = new long[K+1]; C = new long[K+1];
        for (int i=1;i<=K;i++) A[i] = B[i] = (long)-1e18;
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++){
            int v = Integer.parseInt(st.nextToken());
            for (int j=1;j<=K;j++) A[j] += v;
            for (int j=1;j<=K;j++) if (A[j] < v){
                for (int k=K-1;k>=j;k--) A[k+1] = A[k];
                A[j] = v;
                break;
            }
            for (int j=1,l=1,r=1;j<=K;j++){
                if (A[l] > B[r]) C[j] = A[l++];
                else C[j] = B[r++];
            }
            for (int j=1;j<=K;j++) B[j] = C[j];
        }
        System.out.println(B[K]);
    }
}
