import java.io.*;
import java.util.*;
  
class Jewel implements Comparable<Jewel>{
    public Jewel(int w, int c) {
        this.w = w;
        this.c = c;
    }
  
    int w, c;
  
    public int compareTo(Jewel ot) {
        return w - ot.w;
    }
}
  
public class source {
    static int N, K;
    static int[] cnt = new int[1000001];
    static Jewel[] A;
    static int[] B;
      
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
  
        A = new Jewel[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            A[i] = new Jewel(w, h);
        }
        B = new int[K];
        for (int i=0;i<K;i++) B[i] = Integer.parseInt(br.readLine());
          
        Arrays.sort(A);
        Arrays.sort(B);
          
        long ans = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i=0,j=0;i<K;i++){
            while (j < N && A[j].w <= B[i]){
                que.add(-A[j].c);
                j++;
            }
            if (!que.isEmpty())
                ans += -que.poll();
        }
        System.out.println(ans);
    }
}
