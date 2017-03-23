import java.io.*;
import java.util.*;
 
/*
 * 구간의 대표값
 * Representative
 */
public class Representative {
    static int N, Q;
    static int TS, ST;
     
    static long[] S;
    static int[] mntree, mxtree;
     
    static int get_min(int l, int r) {
        int ret = Integer.MAX_VALUE;
        l += ST; r += ST;
        while (l <= r){
            if ((l&1) == 1) ret = Math.min(ret, mntree[l++]);
            if ((r&1) == 0) ret = Math.min(ret, mntree[r--]);
            l >>= 1; r >>= 1;
        }
        return ret;
    }
     
    static int get_max(int l, int r) {
        int ret = Integer.MIN_VALUE;
        l += ST; r += ST;
        while (l <= r){
            if ((l&1) == 1) ret = Math.max(ret, mxtree[l++]);
            if ((r&1) == 0) ret = Math.max(ret, mxtree[r--]);
            l >>= 1; r >>= 1;
        }
        return ret;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (TS=1;TS<N;TS<<=1); TS <<= 1; ST = TS/2-1;
        mntree = new int[TS]; mxtree = new int[TS];
        S = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++){
            int v = Integer.parseInt(st.nextToken());
            S[i] = S[i-1] + v;
            mntree[ST+i] = mxtree[ST+i] = v;
        }
        for (int i=ST;i>0;i--){
            mntree[i] = Math.min(mntree[i+i], mntree[i+i+1]);
            mxtree[i] = Math.max(mxtree[i+i], mxtree[i+i+1]);
        }
        Q = Integer.parseInt(br.readLine());
        while (Q-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int mn = get_min(a, b), mx = get_max(a, b); long sum = S[b] - S[a-1];
            bw.write(mn + " " + mx + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
