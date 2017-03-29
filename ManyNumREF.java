import java.io.*;
import java.util.*;
  
public class source {
    static int N;
    static int[] A;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        for (int i=0;i<N;i++) A[i] = Integer.parseInt(br.readLine());
        Arrays.sort(A);
        int mx = 0, mxv = 0, prv = 0, cnt = 0;
        for (int t: A){
            if (prv == t) cnt++;
            else{
                cnt = 1;
                prv = t;
            }
            if (mx < cnt){
                mx = cnt;
                mxv = t;
            }
        }
        System.out.println(mxv);
    }
}
