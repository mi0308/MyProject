import java.io.*;
import java.util.*;
 
public class source {
    static final int MOD = (int)1e9 + 7;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = (int)(Long.parseLong(st.nextToken())%MOD);
        long m = Long.parseLong(st.nextToken());
        int ans = 1;
        for (int v=a;m>0;m>>=1,v=(int)((long)v*v%MOD))
            if ((m&1) == 1)
                ans = (int)((long)ans*v%MOD);
        System.out.println(ans);
    }
}
