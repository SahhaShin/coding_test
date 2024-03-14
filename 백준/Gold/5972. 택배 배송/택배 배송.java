import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<Node>[] adj;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=0;i <N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String ABC = br.readLine();
            st = new StringTokenizer(ABC, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj[A].add(new Node(B, C));
            adj[B].add(new Node(A, C));
        }

        //입력 끝

        //1. dist 최대값으로 초기화
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        //2. 다익스트라
        System.out.println(Dijkstra());

    }
    
    public static int Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1]; 
        
        dist[1] = 0;
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visited[cur.to] = true;

            if(cur.to == N){
                return cur.cow;
            }

            for(Node next: adj[cur.to]){
                if(visited[next.to]) continue;

                if(dist[next.to] > dist[cur.to]+next.cow){
                    dist[next.to] = dist[cur.to]+next.cow;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        return 0;
    }

    public static class Node implements Comparable<Node>{
        int to;
        int cow;
        public Node(int to, int cow){
            this.to = to;
            this.cow = cow;
        }

        @Override
        public int compareTo(Node o){
            return this.cow>o.cow?1:-1;
        }
    }
}