import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 탑 
 * Stack
 */
public class Top {

	static int[] ins, ans;
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        
        ins = new int[N+1];
        ans = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
         
            int tmp = Integer.parseInt(st.nextToken());

            ins[i] = tmp;
            ans[i] = -1;
        }

        search();
        
        for(int i=1;i<=N;i++){
        	if(ans[i] != -1)
        		bw.write(ans[i]+" ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
	}
	static void search(){
        Stack<Integer> S = new Stack<Integer>();
        
        for (int i=1;i<=N;i++){
            while (!S.isEmpty() && ins[S.peek()] <= ins[i]) {
            	S.pop();
            }
        	int tmp = S.isEmpty() ? 0 : S.peek();
        	
        	ans[i] = tmp;
        	
        	// add index not value
        	S.push(i);
        }
	}

}
