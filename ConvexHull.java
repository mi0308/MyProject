
import java.io.*;
import java.util.*;

/*
 * Convex Hull
 * y좌표 기준으로 sort
 * 기준점 선택
 * 나머지 점에 대해 각도기준 sort
 * CCW
 */

public class ConvexHull {

	static int N;
	static long ans;
	static pt[] point;
	static boolean chk=false;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
		N = Integer.parseInt(br.readLine());
		point = new pt[N];
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			point[i] = new pt(x, y);
		}
		
		//1.find base point
		for(int i=1;i<N;i++){
			if(point[0].y > point[i].y  || point[0].y == point[i].y && point[0].x > point[i].x){
				pt tmp = point[0];
				point[0] = point[i];
				point[i] = tmp;
			}
		}
		
		//2. 0점 변환 x=0, y=0;
		for(int i=N-1;i>=0;i--){
			point[i].x -= point[0].x;
			point[i].y -= point[0].y;
		}
		
		//3. sort all points
		Arrays.sort(point, 1, N, new Comparator<pt>(){
			public int compare(pt o1, pt o2){
				pt base = new pt(0, 0);
				int chk = ccw(base, o1, o2);
				
				return chk > 0 ? -1 : (chk == 0 ? 0 : 1);
			}
		});
		
		Stack<Integer> stack = new Stack<>(); 
		stack.add(0);

		//4. scan for all
		for(int i=1;i<N;i++){
			
			while( stack.size()>1 && ccw(point[stack.get(stack.size()-2)],
					                     point[stack.get(stack.size()-1)],
					                     point[i])<=0) {
				stack.remove(stack.size()-1);
			}
			stack.add(i);
		}
		
		System.out.println(stack.size());
		
	}
	static int ccw(pt a, pt b, pt c){
		return ccw(a.x, a.y, b.x, b.y, c.x, c.y);
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

class pt{
	int x, y;
	
	public pt(int x, int y){
		this.x = x;
		this.y = y;
	}
}
