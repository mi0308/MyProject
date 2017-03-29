import java.io.*;
import java.util.*;
 
public class source {
    static int N;
    static int[] X, Y;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        X = new int[N+1];
        Y = new int[N+1];
        for (int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        for (int i=1;i<=N;i++){
            int j = i%N+1;
            ans += (long)X[i]*Y[j] - (long)X[j]*Y[i];
        }
        ans = Math.abs(ans);
        System.out.print(ans>>1);
        System.out.printf(".%d", (int)(ans&1)*5);
         
    }
}
