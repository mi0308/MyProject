import java.io.*;
import java.util.*;
/*
 * 가장 많은 수
 */
public class MostManyNum {
 
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      BufferedReader br = new BufferedReader(new FileReader("C:\\input.txt"));
        int ans;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
         
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }
   
        //sort
        Arrays.sort(A);
   
        int cnt = 1;
        int anscnt = 1;
        ans = A[0];
        for(int i=0; i<N-1; i++){
            if(A[i] == A[i+1]){
                cnt ++;
 
                if(cnt > anscnt){
                    ans = A[i];
                    anscnt = cnt;
                }
            }else{
                cnt = 1;
            }
        }
        System.out.println(ans);
    }
}
