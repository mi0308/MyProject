import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 그래프 순회
 * BFS, DFS
 * Adjacent List 사용  
 */
public class Graph {

	static int N, M, S;
	static ArrayList<Integer>[] INS;
    static ArrayList<Integer> DFS, BFS;
    static boolean[] visit;
    static boolean chk=true;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        INS = new ArrayList[N+1];
        for (int i=1;i<=N;i++){
        	INS[i] = new ArrayList<>();
        }
        
        for (int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            //add child
            INS[a].add(b);
            
            //add parents
            INS[b].add(a);
        }
        
        for (int i=1;i<=N;i++) {
            Collections.sort(INS[i]);
        }

        visit = new boolean[N+1];
        DFS = new ArrayList<>();
        dfs(S);
        
        visit = new boolean[N+1];
        BFS = new ArrayList<>();
        bfs(S);
        
        for(int i : DFS){
        	System.out.print(i + " ");
        }
        System.out.println();
        
        
        for(int i : BFS){
        	System.out.print(i + " ");
        }
        System.out.println();        
	}

    //use Recurrsive function
    static void dfs(int n){
    	
    	DFS.add(n);
    	visit[n] = true;
    	
    	for(int i : INS[n]) {
    		if(!visit[i]){
    			dfs(i);
    		}
    	}
    }
    
    //use Queue
    static void bfs(int n){
    	Queue<Integer> q = new LinkedList<>();
    	
    	q.add(n);
    	
    	visit[n] = true;
    	
    	while(!q.isEmpty()) {
    		int c = q.poll();
    		
    		BFS.add(c);
    		for(int i : INS[c]) {
    			if(!visit[i]){
    				visit[i] = true;
    				q.add(i);
    			}
    		}
    	}
    }
}
