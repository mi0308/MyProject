import java.io.*;
import java.util.*;
 
public class source {
    static int K, N;
    static int[] A, B;
    static ArrayList<Integer> arr;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[K+1];
        for (int i=1;i<=K;i++) A[i] = Integer.parseInt(br.readLine());
        B = new int[K+1];
        arr = new ArrayList<>();
        arr.add(1);
        for (int i=1;i<=N;i++){
            long mn = Long.MAX_VALUE;
            for (int j=1;j<=K;j++){
                long v = (long)A[j] * arr.get(B[j]);
                mn = Math.min(mn, v);
            }
            for (int j=1;j<=K;j++){
                if ((long)A[j] * arr.get(B[j]) == mn) B[j]++;
            }
            arr.add((int)mn);
        }
        System.out.println(arr.get(N));
    }
}
