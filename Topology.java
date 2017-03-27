import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 위상정렬
 * Topology sort
 * finish time 이 빠른 것을 가장 오른 쪽으로 배치
 */
public class Topology {

	static boolean chk=false;

	public static void main(String[] args) throws Exception {
    	 
        List<Integer> result = new ArrayList<Integer>();
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 노드 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수
 
        // 각 노드별 dest노드 정보를 list 형태로 .
        List<Integer>[] graph = new ArrayList[V+1];
        //각 노드별 indegree 카운트를 담는 배열
        int indegree[] = new int[V+1];
         
        Arrays.fill(indegree, 0);
         
         
        // 간선정보를 입력받는다.
        // destination 노드별로 indegree( 들어오는 연결 ) 카운트를 배열에 담고
        // 출발노드별로, 도착지노드 정보를 리스트로 관리한다.
        int firstNode, destNode;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            firstNode = Integer.parseInt(st.nextToken());
            destNode = Integer.parseInt(st.nextToken());
             
            indegree[destNode]++;
             
            if( graph[firstNode] == null ){
                graph[firstNode] = new ArrayList<Integer>();
                graph[firstNode].add(destNode);
            }else{
                graph[firstNode].add(destNode);
            }
                 
        }
        
        if(chk) {
	        for( int i=0; i < graph.length; i++){
	            if( graph[i]!=null) {
	                System.out.println(graph[i].toString());
	            }
	        }
        }
 
        // in-degree가 0 인 애들을 먼저 찾는다. ( 즉 들어오는 간선이 없는 애들 )
        int remainNode = V;
        while( remainNode > 0 ){
            List<Integer> tmpList = new ArrayList<Integer>();
            for (int i = 1; i <= V; i++) {
                if( indegree[i] == 0 ) {
                    tmpList.add(i);
                    remainNode--;
                    indegree[i]--;
                }
            }
             
            if( !tmpList.isEmpty() && tmpList.size() > 0) {
                for( int i=0;i < tmpList.size(); i++){
                	int v = tmpList.get(i);
                    for( int j=0;  graph[v] != null && j < graph[v].size(); j++) {
                        int destIdx = graph[v].get(j);
                        indegree[destIdx]--;
                    }
                }
                 
                result.addAll(tmpList);
            }
        }
         
        for( int i=0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
	}

}
