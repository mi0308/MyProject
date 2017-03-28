import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 가장 먼 두 도시
 * - Floyd Warshall
 */
public class TheFarestCity {

	static int N;
	static int[][] DP;
	static int ANS;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		DP = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++){
				DP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=1;k<=N;k++){
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k][j]);
				}
			}
		}
		
		ANS = 0;
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				ANS = Math.max(ANS, DP[i][j]);
			}
		}
		bw.write(ANS+"");
		bw.newLine();
		bw.flush();
		bw.close();
	}

}
