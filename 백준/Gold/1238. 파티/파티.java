import java.util.*;

public class Main {

    public static class Node implements Comparable<Node>{
        int num;
        int fee;
        public Node(int num, int fee){
            this.num=num;
            this.fee=fee;
        }

        @Override
        public int compareTo(Node o){
            return this.fee>o.fee?1:-1;
        }
    }

    static int N;
    static int M;
    static int X;
    static List<Node>[] adj;
    static int result;
    static int[] start_dist;
    static int[] end_dist;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M  = sc.nextInt();
        X = sc.nextInt();


        adj = new ArrayList[N+1];//1부터 시작
        for(int i=1;i<N+1;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int fee = sc.nextInt();
            adj[start].add(new Node(end, fee));
        }

        //입력 끝

        //도착지에서 출발지까지 오는 데 가장 최단 거리 저장
        end_dist = new int[N+1];
        for(int i=1;i<N+1;i++){
            end_dist[i]=Integer.MAX_VALUE;
        }
        end_dist[X] = 0;

        end_dijstra(X);

        //각 섬에서 X번 섬까지 오는 데 가장 오래 걸리는 시간은?
        for(int start=1;start<=N;start++){
            
            start_dist = new int[N+1];
            for(int i=1;i<N+1;i++){
                start_dist[i]=Integer.MAX_VALUE;
            }

            start_dist[start] = 0;

            start_dijstra(start);
        }

        System.out.println(result);

    }

    public static void start_dijstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[N+1];

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.num]){
                visited[cur.num] = true;

                for(int i=0;i<adj[cur.num].size();i++){
                    int next_num = adj[cur.num].get(i).num;
                    int next_fee = adj[cur.num].get(i).fee;

                    if(start_dist[next_num] > start_dist[cur.num]+next_fee){
                        start_dist[next_num] = start_dist[cur.num]+next_fee;
                        pq.add(new Node(next_num, start_dist[next_num]));
                    }
                }
            }
        }

        result = Math.max(end_dist[start]+start_dist[X], result);
    }


    public static void end_dijstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[N+1];

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.num]){
                visited[cur.num] = true;

                for(int i=0;i<adj[cur.num].size();i++){
                    int next_num = adj[cur.num].get(i).num;
                    int next_fee = adj[cur.num].get(i).fee;

                    if(end_dist[next_num] > end_dist[cur.num]+next_fee){
                        end_dist[next_num] = end_dist[cur.num]+next_fee;
                        pq.add(new Node(next_num, end_dist[next_num]));
                    }
                }
            }
        }

        result = Math.max(end_dist[X], result);
    }
}