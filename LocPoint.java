import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 점의 위치
 * CCW
 * 두 선분의 교차 조검
 * - CCW(a,b,c) * CCW(a,b,d) = -1
 *   && CCW(c,d,a) * CCW(c,d,b) = -1
 */
public class LocPoint {

	static int N;
	static long ans;
	static int[] X, Y;
	static boolean chk=false;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
		N = Integer.parseInt(br.readLine());
		X = new int[N+1];
		Y = new int[N+1];
		StringTokenizer st;
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
	        	
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
	        
	    st = new StringTokenizer(br.readLine());
	    int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
	    
		if(check(x1, y1)){
			System.out.println("in");
		}else{
			System.out.println("out");
		}
		if(check(x2, y2)){
			System.out.println("in");
		}else{
			System.out.println("out");
		}
	}
	
	static boolean check(int x1, int y1) {
		int x2 = (int)1e9 + 1, y2 = y1 + 1;
		boolean ret = false;
		for (int i=1;i<=N;i++){
			int j = i%N + 1;
			if (is_cross(x1, y1, x2, y2, X[i], Y[i], X[j], Y[j]))
				ret ^= true;
		}
		return ret;
	}

	static boolean is_cross(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
		return ccw(ax, ay, bx, by, cx, cy) * ccw(ax, ay, bx, by, dx, dy) < 0 &&
		       ccw(cx, cy, dx, dy, ax, ay) * ccw(cx, cy, dx, dy, bx, by) < 0;
	}

	static int ccw(int ax, int ay, int bx, int by, int cx, int cy){
		long ret = (long)ax*by + (long)bx*cy + (long)cx*ay - (long)bx*ay - (long)cx*by - (long)ax*cy;
//		long ret = (long)(bx-ax)*(cy-ay) - (long)(cx-ax)*(by-ay);
		if(ret>0){
			return 1;  // left, ccw
		}else if(ret <0){
			return -1; // right, cw
		}else{
			return 0;  // aline
		}
	}
  
}
