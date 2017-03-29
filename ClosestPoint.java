import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ClosestPoint {

    static Point[] DP, TMP;
    static int ans;
    static int N;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        DP = new Point[N+1];
        TMP = new Point[N+1];
        for(int i=1;i<=N;i++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        
        	DP[i] = new Point(a, b);
        }
        
        Arrays.sort(DP, 1, N+1, new Comparator<Point>(){
        	public int compare(Point a, Point b){
        		return a.x - b.x;
        	}
        });
        
        ans = dfs(1,N);
        
        bw.write(ans+"");
        bw.newLine();
        bw.flush();
        bw.close();
	}
    static int dfs(int s, int e){
    	int ret = Integer.MAX_VALUE;
    	
    	/*
    	 * 최소화된 point에서 검색할 대상은 8개
    	 */
    	if (e-s < 9){
            for (int i=s;i<e;i++){
            	for (int j=i+1;j<=e;j++){
            		ret = Math.min(ret, dist(DP[i], DP[j]));
            	}
            }
            
            Arrays.sort(DP, s, e+1, new Comparator<Point>() {
                public int compare(Point a, Point b) {
                    return a.y - b.y;
                }
            });
            return ret;
        }
        int mid = s+e >> 1;
        int X = DP[mid].x;
        int d = Math.min(dfs(s, mid), dfs(mid+1, e));
        
        merge(s, mid, e);
        
        ArrayList<Point> arr = new ArrayList<>();
        for (int i=s;i<=e;i++){
            int ix = DP[i].x - X;
        	if (ix*ix <= d){
                arr.add(DP[i]);
            }
        }
        
        ret = d;
        for (int i=0;i<arr.size();i++){
            for (int j=i+1;j<arr.size()&&j-i<13;j++){
                ret = Math.min(ret, dist(arr.get(i), arr.get(j)));
            }
        }
    	
    			
    	return ret;
    }
    static int dist(Point a, Point b) {
        return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
    }
    static void merge(int s, int m, int e){
    	for(int l=s, r=m+1,i=s;i<=e;i++){
    		if(r>e || l <= m && DP[l].y<DP[r].y) {
    			TMP[i] = DP[l++];
    		}else{
    			TMP[i] = DP[r++];
    		}
    	}
    	
    	for(int i=s;i<=e;i++){
    		DP[i] = TMP[i];
    	}
    }
}

class Point{
	int x, y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
