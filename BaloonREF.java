import java.io.*;
import java.util.*;
 
 
 
public class source {
    static int N;
    static int[] cnt = new int[1000001];
     
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++){
            int h = Integer.parseInt(st.nextToken());
            if (cnt[h] > 0) cnt[h]--;
            else ans++;
            cnt[h-1]++;
        }
        System.out.println(ans);
    }
}
