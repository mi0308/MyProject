import java.io.*;
import java.util.*;
 
public class source {
    static int N, Q, TS, ST;
    static int[] A;
    static long[] tree;
     
    static void build_tree() {
        for (TS=1;TS<N;TS<<=1); TS <<= 1;
        ST = TS/2-1;
         
        tree = new long[TS];
        for (int i=1;i<=N;i++) tree[ST+i] = i;
        for (int i=ST;i>0;i--)
            tree[i] = tree[i+i] + tree[i+i+1];
    }
     
    static void update(int n, int v) {
        n += ST;
        tree[n] = v;
        for (n>>=1;n>0;n>>=1)
            tree[n] = tree[n+n] + tree[n+n+1];
    }
     
    static long get_sum(int l, int r) {
        long ret = 0;
        l += ST; r += ST;
        while (l <= r){
            if ((l&1) == 1)
                ret += tree[l++];
            if ((r&1) == 0)
                ret += tree[r--];
            l >>= 1; r >>= 1;
        }
        return ret;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        N = Integer.parseInt(br.readLine());
        Q = Integer.parseInt(br.readLine());
         
        build_tree();
         
        while (Q-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (t == 0) update(a, b);
            else bw.write(get_sum(a, b) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
