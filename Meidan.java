import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 중앙값 :  MaxHeap, MinHeap
 * PriorityQueue
 */
public class Median {

	static int N;
	static int[] INS, ANS; 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        INS = new int[N+1];
        ANS = new int[N+1];
        for (int i=1;i<=N;i++){
            int x = Integer.parseInt(br.readLine());
            INS[i] = x;
            
            ANS[i] = -1;
        }
        
        search();
        
        for(int i=1;i<=N;i++){
        	if(ANS[i] != -1) {
        		System.out.println(ANS[i]);
        	}
        }
	}
	static void search(){
		//Maxheap : data io -> add -m pop -m peek -m
        PriorityQueue<Integer> L = new PriorityQueue<Integer>();
		//Minheap
        PriorityQueue<Integer> R = new PriorityQueue<Integer>();
        
        for (int i=1;i<=N;i++){
            int x = INS[i];
             
            if (R.isEmpty() || R.peek() > x) {
            	L.add(-x);
            }else {
            	R.add(x);
            }
             
            while (L.size() > R.size()+1){
                R.add(-L.poll());
            }
            while (R.size() > L.size()) {
                L.add(-R.poll());
            }
             
            if (i % 2 == 1) {
            	ANS[i] = (-L.peek());
            }
        }		
	}
}
