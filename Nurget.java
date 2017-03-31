import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 너겟
 */
public class Nurget {

	static int N, ans;
	static ArrayList<Integer>[] list;
	static int[] arr, dp, A;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		list = new ArrayList[N+1];
		process1();
		
//		print(dp);
		
		bw.write(ans+"");
		bw.newLine();
		bw.flush();
		bw.close();
		
	}
	
	static void process(){

		for(int i=1;i<=N;i++){
			for(int j=0;j<arr[i-1];j++){
				list[i].add(j);
			}
		}
		
		for(int i=0;i<dp.length;i++){
			if(dp[i]==0){
				ans = i;
				break;
			}
		}
		
	}
	
	static void process1(){
		dp[0]=1;
		for(int i=0;i<N;i++){
			dp[arr[i]] = 1;
			for(int j=i+1;j<N;j++){
				int idx = arr[i] + arr[j];
				dp[idx] = 1;
			}
		}

		for(int i=1;i<=dp.length;i++){
			if(dp[i] == 0){
				ans = i;
				break;
			}
		}
		
	}
	
	static void print(){
		for(int i=0;i<N;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static void print(int[] arr){
		int x = arr.length;
		for(int i=0;i<x;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
