import java.util.*;
import java.io.*;

// 1번 정점에서 N번 정점으로 이동할 때,
// 주어진 두 정점을 반드시 거치면서 최단 경로로 이동

class Main {
    static int N;
    static List<Edge>[] adj;
    static int[] essential_path = new int[2];

    static int[] dist;
    static int INF = 200000 * 1000;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NE = br.readLine();
        StringTokenizer st = new StringTokenizer(NE, " ");
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];//정점 1부터 시작
        for(int i=0; i<N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            String abc = br.readLine();
            st = new StringTokenizer(abc, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
        }

        String paths = br.readLine();
        st = new StringTokenizer(paths, " ");
        essential_path[0] = Integer.parseInt(st.nextToken());
        essential_path[1] = Integer.parseInt(st.nextToken());

        //입력 끝

        dist = new int[N+1]; //1부터 시작
        
        //1 -> Node1 -> Node2 -> N
        int ans1 = 0;
        ans1 += Dijkstra(1, essential_path[0]);
        ans1 += Dijkstra(essential_path[0], essential_path[1]);
        ans1 += Dijkstra(essential_path[1], N); 
    
        //2 -> Node2 -> Node1 -> N
        int ans2 = 0;
        ans2 += Dijkstra(1, essential_path[1]);
        ans2 += Dijkstra(essential_path[1], essential_path[0]);
        ans2 += Dijkstra(essential_path[0], N);

        int ans = ans1>=INF && ans2>=INF ? -1 : Math.min(ans1, ans2);
        System.out.println(ans);
    }

    public static int Dijkstra(int startNode, int endNode){
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[N+1];//정점은 1부터 시작
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.offer(new Edge(startNode, 0));
        dist[startNode] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(visited[cur.num]) continue;
            
            visited[cur.num] = true;
            
            for(int i=0; i<adj[cur.num].size(); i++){
                Edge next = adj[cur.num].get(i);

                if(dist[next.num]>dist[cur.num]+next.len){
                    dist[next.num] = dist[cur.num]+next.len;
                    pq.offer(new Edge(next.num, dist[next.num]));
                }
            }
        }

        return dist[endNode];
    }

    public static class Edge implements Comparable<Edge>{
        int num;
        int len;
        public Edge(int num, int len){
            this.num = num;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o){
            return this.len>o.len?1:-1;
        }
    }    
}