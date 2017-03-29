
import java.io.*;
import java.util.*;
/*
 * 보석
 * 가방, 보석 정렬
 */
public class Gem {

    static int N, K;
    static int[] cnt = new int[1000001];
    static Jewel[] gem;
    static int[] bag;
    static boolean chk=false;
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
  
        gem = new Jewel[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            gem[i] = new Jewel(w, c);
        }
        
        bag = new int[K];
        for(int i=0;i<K;i++){
        	int b = Integer.parseInt(br.readLine());
        	
        	bag[i] = b;
        }
        
        Arrays.sort(gem, new Comparator<Jewel>(){
        	public int compare(Jewel o1, Jewel o2){
        		return o1.w - o2.w;
        	}
        });
        Arrays.sort(bag);
        
        if(chk) print();
        
        long ans=0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i=0,j=0;i<K;i++){
            while (j < N && gem[j].w <= bag[i]){
                que.add(-gem[j].c);
                j++;
            }
            if (!que.isEmpty())
            	ans += -que.poll();
        }
        
        bw.write(ans+"");
        bw.newLine();
        bw.flush();
        bw.close();
	}
    
    static void print(){
    	System.out.println("gem order");
        for (int i=0;i<N;i++){
            int w = gem[i].w;
            int c = gem[i].c;
            System.out.println(w+"   "+c);
        }
        
    	System.out.println("bag order");
        for(int i=0;i<K;i++){
        	System.out.print(bag[i]+"  ");
        }
        System.out.println();
    }

}

class Jewel {
	public Jewel(int w, int c){
		this.w = w;
		this.c = c;
	}
	 int w, c;
}
