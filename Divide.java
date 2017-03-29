import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 나누기
 * 
 */
public class Divide {

    static int N;
    static int[][] DP = new int[130][130];
    static int[] ans = new int[2];
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int j=1;j<=N;j++){
	        	int M = Integer.parseInt(st.nextToken());
	        	DP[i][j] = M;
	        }
        }
        
        search(N, 1, 1);

        bw.write(ans[0]+"");
        bw.newLine();
        bw.write(ans[1]+"");
        bw.newLine();
        bw.flush();
        bw.close();
	}
    static void search(int n, int x, int y){
    	boolean chk = true;
    	
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			if(DP[x][y] != DP[x+i][y+j]){
    				chk=false;
    			}
    		}
    	}
    	
    	if(chk){
    		ans[DP[x][y]]++;
    		return;
    	}
    	
    	int z = n/2;
    	search(z, x, y);
    	search(z, x+z, y);
    	search(z, x, y+z);
    	search(z, x+z, y+z);
    }
}
