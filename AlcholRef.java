import java.io.*;
import java.util.*;
 
class Plan implements Comparable<Plan> {
    public Plan(int t, int d) {
        super();
        this.t = t;
        this.d = d;
    }
 
    int t, d;
     
    @Override
    public int compareTo(Plan ot) {
        if (t * ot.d < ot.t * d) return -1;
        if (t * ot.d > ot.t * d) return 1;
        return 0;
    }
     
}
 
public class source {
    static int N;
    static ArrayList <Plan> A = new ArrayList<>();
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            A.add(new Plan(t, d));
        }
        Collections.sort(A);
        long sum = 0, ans = 0;
        for (Plan p: A){
            ans += sum * p.d;
            sum += p.t;
        }
        System.out.println(ans << 1);
    }
}
