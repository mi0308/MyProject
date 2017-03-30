import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
/*
 * 단순 다각형의 넓이
 */
public class AreaSimplePolygon {
  
    static int N;
    static long ans;
    static int[][] point;
    static boolean chk=false;
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
        N = Integer.parseInt(br.readLine());
          
        point = new int[N+1][2];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
              
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
              
            point[i][0] = x;
            point[i][1] = y;
        }
          
        process();
    
    }
    static void process(){
        ans = 0;
        for(int i=1;i<=N;i++){
            int j = i%N+1;
            ans += (long)point[i][0] * point[j][1]
                    - (long)point[j][0] * point[i][1];
        }
        ans = Math.abs(ans);
        System.out.printf("%d.%d\n", ans/2, ans%2 == 0 ? 0 : 5);
    }
  
}
