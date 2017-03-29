import java.io.*;
import java.util.*;
  
/*
 * 정렬을 이용한 동굴 풀이
 */
 
public class source {
    static int N, H;
    static ArrayList<Integer> A, B;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        A = new ArrayList<Integer>();
        B = new ArrayList<Integer>();
        for (int i=0;i<N;i++){
            int h = Integer.parseInt(br.readLine());
            if (i % 2 == 0) A.add(h);
            else B.add(H-h+1);
        }
        Collections.sort(A);
        Collections.sort(B);
        int ans = Integer.MAX_VALUE, anscnt = 0;
        for (int i=1,pt1=0,pt2=0;i<=H;i++){
            while (pt1 < A.size() && A.get(pt1) < i) pt1++;
            while (pt2 < B.size() && B.get(pt2) <= i) pt2++;
             
            /*
             * (A.size() - pt1) : 높이 i를 지나는 석순의 개수
             * pt2 : 높이 i를 지나는 종유석 개수
             */
            int cnt = (A.size() - pt1) + pt2;
            if (ans > cnt){
                ans = cnt;
                anscnt = 1;
            }
            else if (ans == cnt)
                anscnt++;
        }
        System.out.println(ans + " " + anscnt);
    }
}
