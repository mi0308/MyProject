import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
        
public class NumberofInversion { 
        
    public static void main(String[] args)throws Exception {

    	int answer;
//      System.setIn(new FileInputStream("res/sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        long t1 = System.currentTimeMillis();
        answer = countingInversions(a);
        long t2 = System.currentTimeMillis();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer+"");
        bw.newLine();
        bw.flush();
        bw.close();
        
        System.out.println("duration="+(t2-t1)+" milliseconds)");
    }
 
    private static int countingInversions(int[] a) {
        int n = a.length;
        int[] buf = new int[n];           
        int cnt = count(a,0,n-1,buf);
        
        return cnt;
    }
    
    private static int count(int[] a, int s, int e, int[] buf){
        if((e-s)<1) {
                 return 0;
        }       
        
        int m = (s+e) / 2;
        int leftCount = count(a,s,m,buf);
        int rightCount = count(a,m+1,e,buf);
        int mergeCount = merge(a,s,m,e,buf);
        System.arraycopy(buf, s, a, s, (e-s)+1);
        
        return leftCount + rightCount + mergeCount;
    }
    
    private static int merge(int[]a,int s, int m, int e, int[] buf){
        //System.out.println("merge("+s+" "+e+")");
        int left=s;
        int right=m+1;
        int count=0;
        for(int k=s;k<=e;k++){
                 if(left<=m && ( (right>e) || (a[left] <= a[right]) ) ){
                         buf[k] = a[left++];                                 
                 }else{
                         buf[k] = a[right++];
                         count = count + (m-left+1);
                 }
        }
        return count;
    }
}
