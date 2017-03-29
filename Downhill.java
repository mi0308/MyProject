import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 내리막길
 * DP
 * 
 */
public class Downhill {

    static int[][] MAP, DP;
    static int N, M, ans;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[N+1][M+1];
        DP = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
        	st = new StringTokenizer(br.readLine());
        	for(int j=1;j<=M;j++){
        		MAP[i][j] = Integer.parseInt(st.nextToken());
        		DP[i][j] = -1;
        	}
        }
//        print();
        ans = process(N, M);

        bw.write(ans+"");
        bw.newLine();
        bw.flush();
        bw.close();
	}
    static void print(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(process(i, j) + "\t");
            }
            System.out.println();
        }
    }
    static int process(int x, int y){
    	
    	if(x==1 && y==1){
    		return 1;
    	}
    	/*
    	if(DP[x][y] != -1){
    		return DP[x][y];
    	}

        if (MAP[x][y] > MAP[x][y + 1]) { // point for east
        	DP[x][y] += process(x, y + 1);
        }
        if (MAP[x][y] > MAP[x][y - 1]) { // point for west
        	DP[x][y] += process(x, y - 1);
        }
        if (MAP[x][y] > MAP[x + 1][y]) { // point for south
        	DP[x][y] += process(x + 1, y);
        }
        if (MAP[x][y] > MAP[x - 1][y]) { // point for north
        	DP[x][y] += process(x - 1, y);
        }
        */


    	int East  = 0;
    	int West  = 0;
    	int South = 0;
    	int North = 0;
    	
        if (y + 1 < N) {// boundary check
            if (MAP[x][y] < MAP[x][y + 1]) { // point for east
                if (DP[x][y + 1] == -1) {
                    East = process(x, y + 1);
                    DP[x][y + 1] = East;
                } else {
                    East = DP[x][y + 1];
                }
            }
        }
        if (y - 1 >= 0) {// boundary check
            if (MAP[x][y] < MAP[x][y - 1]) { // point for west
                if (DP[x][y - 1] == -1) {
                    West = process(x, y - 1);
                    DP[x][y - 1] = West;
                } else {
                    West = DP[x][y - 1];
                }
            }
        }
        if (x + 1 < M) {// boundary check
            if (MAP[x][y] < MAP[x + 1][y]) { // point for south
                if (DP[x + 1][y] == -1) {
                    South = process(x + 1, y);
                    DP[x + 1][y] = South;
                } else {
                    South = DP[x + 1][y];
                }
            }
        }
        if (x - 1 >= 0) {// boundary check
            if (MAP[x][y] < MAP[x - 1][y]) { // point for north
                if (DP[x - 1][y] == -1) {
                    North = process(x - 1, y);
                    DP[x - 1][y] = North;
                } else {
                    North = DP[x - 1][y];
                }
            }
        }
        return East + West + South + North;
        
//        return DP[x][y];
    }

}
