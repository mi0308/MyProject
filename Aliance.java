import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 동맹의 동맹은 동맹
 */
public class Aliance {

	static int[] P;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Q = Integer.parseInt(br.readLine());
        
        P = new int[N+1];
        for(int i=0;i<N;i++){
        	P[i] = i;
        }
        
        for(int i=0;i<Q;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int tmp = Integer.parseInt(st.nextToken());
            int a   = Integer.parseInt(st.nextToken());
            int b   = Integer.parseInt(st.nextToken());
            if(tmp==0){
                //Aliance : union
            	Union(a, b);
            }else if(tmp==1){
            	//Find 
            	int x = Find(a);
            	int y = Find(b);
            	
            	if(x==y){
            		System.out.println("1");
            	}else{
            		System.out.println("0");
            	}
            }
        }
	}

	static int Find(int x){
		if(x == P[x]) return x;
		
		return P[x] = Find(P[x]);
	}
	
	static void Union(int x, int y){
		int Pa = Find(x);
		int Pb = Find(y);
		
		if(Pa == Pb) return;
		
		P[Pb] = Pa;
	}
}
