//1번 노드에서 가장 멀리 떨어진 노드의 갯수 (간선)
//1. 연결 노드를 큐에 적재 (노드번호, ORDER)
//2. 연결된 간선이 없는 노드를 발견하면 order 큰 녀석으로 갱신
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public static class Node implements Comparable<Node>{
        int node;
        int order;
        public Node(int node, int order){
            this.node = node;
            this.order = order;
        }
        
        @Override
        public int compareTo(Node o){
            return this.order>o.order?1:-1;
        }
    }
    
    static ArrayList<Node>[] adj;
    static int count=0;
    
    public int solution(int n, int[][] edge) {

        adj = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            //양방향
            adj[edge[i][0]].add(new Node(edge[i][1],0));
            adj[edge[i][1]].add(new Node(edge[i][0],0));
        }
        
        far(n);
        
        return count;
    }
    
    public static void far(int n){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int max_order=0;
        
        //첫 노드 넣기
        q.offer(new Node(1, 0));
        visited[1] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            
            if(max_order<cur.order){
                max_order=cur.order;
                count=1;//새로운 order
            }else if(max_order==cur.order){
                count++;//기존 order
            }
            
            
            for(int i=0;i<adj[cur.node].size();i++){
                Node next = adj[cur.node].get(i);
                if(visited[next.node]) continue;
                
                visited[next.node] = true;
                q.offer(new Node(next.node, cur.order+1));
            }
        }
        
    }
}