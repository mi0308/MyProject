import java.io.*;
import java.util.*;
 
public class source {
    static int N;
    static String[] S = new String[3];
     
    static boolean proc(int m) {
        int[] H = new int[3];
        int diff = 0;
        for (int i=0;i<N;i++){
            int cnt = 0, last = 0;
            for (int j=0;j<3;j++){
                if (S[j].charAt(i) == S[(j+1)%3].charAt(i)){
                    cnt++;
                    last = j;
                }
            }
            if (cnt == 1)
                H[3 - last - (last+1)%3]++;
            else if (cnt == 0)
                diff++;
        }
        Arrays.sort(H);
        while (H[2] > m){
            H[0]++; H[1]++;
            H[2]--;
        }
        if (H[1] > m) return false;
        for (int i=0;i<diff;i++){
            int t = 0;
            for (int j=1;j<3;j++) if (H[t] < H[j]) t = j;
            for (int j=0;j<3;j++) if (t != j) H[j]++;
        }
        Arrays.sort(H);
        return H[2] <= m;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<3;i++) S[i] = br.readLine();
        N = S[0].length();
        int s = 0, e = N, ans = 0;
        while (s <= e){
            int m = s+e >> 1;
            if (proc(m)){
                e = m-1;
                ans = m;
            }
            else s = m+1;
        }
        System.out.println(ans);
    }
}
