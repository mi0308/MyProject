import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 구간합
 * Segment Tree
 */
public class RangeSum {
 
        static int[] arr;
        static long[] tree;
        public static void main(String[] args) throws Exception {
              //String file = "C:/test.txt";
              //System.setIn(new FileInputStream(file));
              int N, Q;
 
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
               
              N = Integer.parseInt(br.readLine());
              Q = Integer.parseInt(br.readLine());
               
              arr = new int[N+1];
              int h = (int)Math.ceil(logB(N,2));
              int tree_size = (1 << (h+1));
              tree = new long[tree_size];
 
              for (int i = 0; i < N; i++) {
                  arr[i] = i+1;
              }
               
              init(1, 0, N-1);
 
              int gubun, x, y;
              long diff, ans, ssum=0;
              for(int i=0;i<Q;i++){
                 StringTokenizer st = new StringTokenizer(br.readLine());
                 gubun = Integer.parseInt(st.nextToken());
                 x     = Integer.parseInt(st.nextToken());
                 y     = Integer.parseInt(st.nextToken());
                     
                 if(gubun == 0){ // 변경
                     x -= 1;
                     diff = y - arr[x];
                     arr[x] = y;

                     update(1, 0, N-1, x, diff);
                 }else if(gubun == 1){ // 합
                     ans = sum(1, 0, N-1, x-1, y-1);
                      
                     ssum += ans;
                     bw.write(ans+"");
                     bw.newLine();
                 }
                 bw.flush();                  
              }
 
     }
      
        public static double logB(double x, double base) {
            return Math.log(x) / Math.log(base);
          }
        static long init(int node, int start, int end){
            if(start == end){
                return tree[node] = arr[start];
            }else{
                return tree[node] = init(node*2, start, (start+end)/2) +
                        init(node*2+1, (start+end)/2+1, end);  
            }
        }
        static void update(int node, int start, int end, int index, long diff) {
            if(index < start  || index > end) return;
             
            tree[node] = tree[node] + diff;
            if(start != end) {
                update(node*2, start, (start+end)/2, index, diff);
                update(node*2+1, (start+end)/2+1, end, index, diff);
            }
        }
        static long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            return sum(node*2, start, (start+end)/2, left, right)
                    + sum(node*2+1, (start+end)/2+1, end, left, right);
        }
 
}
