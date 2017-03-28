
import java.util.*;
import java.io.*;

/*
 * 고속도로 건설
 * Minimum Spanning Tree
 * Union-Find
 */
public class Highway {

	
	static int N, M;
	static int[][] INPUT;
	static int[] PAR;
	static int ANS;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		INPUT = new int[M+1][4];
		for(int i=1;i<=M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			INPUT[i][1] = start;
			INPUT[i][2] = end;
			INPUT[i][3] = cost;
		}
		
		PAR = new int[N+1];
		for(int i=1;i<=N;i++){
			PAR[i] = i;
		}
		
		Arrays.sort(INPUT, new Comparator<int[]>(){	
			public int compare(int[] a1, int[] a2){
				int t1 = a1[3];
				int t2 = a2[3];
				
				return (Integer.compare(t1, t2));
			}
		});
		
		ANS = 0;
		for(int i=1;i<=M;i++){
			int start = INPUT[i][1];
			int end   = INPUT[i][2];
			
			if(Find(start) != Find(end)){
				Union(start, end);
				ANS += INPUT[i][3];
			}else{
				continue;
			}
		}
		
		bw.write(ANS+"");
		bw.newLine();
		bw.flush();
		bw.close();
	}

	static int Find(int x){
		if(PAR[x] == x){
			return x;
		}
		return PAR[x] = Find(PAR[x]);
	}
	
    static void Union(int x, int y){
        int Pa = Find(x);
        int Pb = Find(y);
         
        if(Pa == Pb) return;
         
        PAR[Pb] = Pa;
    }
}
