import java.io.*;
import java.util.*;

/*
 * 지은이의 집
 * 
 * [input]
 * 1
 * 4
 * 5 7
 * 2 2
 * 1 10
 * 10 9
 * 4 1
 * 
 * [output]
 * 
 */
public class Jhouse {
    static int X, N;
    static int[] A;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine()) * (int)1e7;
        N = Integer.parseInt(br.readLine());
        
        
        A = new int[N];
        
        for (int i=0;i<N;i++) {
        	A[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(A);
        
        
        for (int i=0,r=N-1;i<r;i++){
            
        	// binary search 로  r 값 검색
        	while (r > i && A[i]+A[r] > X) {
        		r--;
        	}
        	
            if (r <= i) {
            	break;
            }
            
            if (A[i]+A[r] == X){
                System.out.printf("yes %d %d\n", A[i], A[r]);
                return;
            }
        }
        System.out.println("danger");
    }
    
    /*
     * Another method.
     */
    static int bi_search(int s, int e, int X){
    	int ret =0;
    	
    	if(s>e) ret = -1;
    	int m = (s+e)/2;
    	if(A[m]==X) ret = m;
    	if(A[m]>X) ret = bi_search(s+1, e, X);
    	if(A[m]<X) ret = bi_search(s, e-1, X);
    	
    	return ret;
    }
}
