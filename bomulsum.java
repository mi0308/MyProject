//보물섬

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
  
class Edge implements Comparable<Edge> {
    int n;
    long t;
     
    Edge (int node, long time) {
        this.n = node;
        this.t =  time;
    }
     
    @Override
    public int compareTo(Edge e) {
        int ret = 0;
        if (e.t < this.t) ret = 1;
        if (e.t > this.t) ret = -1;
         
        return ret;
    }
}
 
public class bomulsum  {
    static int INF = Integer.MAX_VALUE;
    static int N, M;
    static int eNode;
    static List<Edge>[] adj;;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    static int[] visit = new int[3000 + 1];
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
            
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        String[] line = br.readLine().split(" ");
         
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
         
        eNode = Integer.parseInt(br.readLine());
         
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<Edge>();
        }
         
        int n1, n2, n3;
        for (int i = 1; i <= M; i++) {
            line = br.readLine().split(" ");
            n1 = Integer.parseInt(line[0]);
            n2 = Integer.parseInt(line[1]);
            n3 = Integer.parseInt(line[2]);
             
            adj[n1].add(new Edge(n2, n3));
        }
         
        long[] time1 = new long[N + 1]; 
        long[] time2 = new long[N + 1];
         
        dijkstra(1, time1);
        dijkstra(eNode, time2);
         
        if (time1[eNode] != INF && time2[1] != INF) {
            System.out.println("YES");
            System.out.println(time1[eNode] + time2[1]);
        }
        else {
            System.out.println("NO");
        }
         
    }
  
    static void dijkstra(int start, long[] dist) {
        for (int i = 1; i <= N; i++) {
            dist[i] = INF; visit[i] = 0;
        }
         
        dist[start] = 0;
        pq.offer(new Edge(start, 0));
 
        Edge now;
        while (!pq.isEmpty()) {
            now = pq.poll();
             
            if (visit[now.n] != 0) continue;
             
            visit[now.n] = 1;
            for (Edge next : adj[now.n]) {
                 
                if (dist[next.n] > (now.t + next.t)) {
                    dist[next.n] = now.t + next.t;
                    pq.offer(new Edge(next.n, now.t + next.t));
                }
                 
            }
             
        }
         
    }
}

