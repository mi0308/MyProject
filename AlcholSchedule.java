import java.io.*;
import java.util.*;

/*
 * 술약속
 * time * distance 정렬
 */
public class Alchol {

    static int N;
    static ArrayList <schedule> INS = new ArrayList<>();
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        for (int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
        
            INS.add(new schedule(t, d));
        }
        
        Collections.sort(INS, new Comparator<schedule>(){
        	public int compare(schedule o1, schedule o2){
        		int c1 = o1.t * o2.d;
        		int c2 = o1.d * o2.t;
        		return c1 < c2 ? -1 : (c1 == c2 ? 0 : 1);
        	}
        });
        long sum = 0, ans = 0;
        for (schedule sch: INS){
            ans += sum * sch.d;
            sum += sch.t;
        }
        
        ans <<= 1;
        
        bw.write(ans+"");
        bw.newLine();
        bw.flush();
        bw.close();
	}

}

class schedule{
	public schedule(int t, int d){
		this.t= t;
		this.d= d;
	}
	int t, d;
}
