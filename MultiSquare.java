import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//거듭제곱 구하기 (최종)
public class day8_multiple {

	static int MOD = 1000000007;
	static long a;
	static long m;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		a %= MOD;
		long ans = 1;
		while(m>=1){
			if((m&1)>=1) ans = ans * a % MOD;
			a = a * a % MOD;
			m>>=1;
			
		}
		System.out.println(ans);
		
		

	}

}
