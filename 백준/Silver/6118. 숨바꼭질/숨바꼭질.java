import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<Integer>[] adj;
    static int result_num;
    static int result_depth;
    static int result_count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1]; //1부터 시작
        for(int i=0; i<N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String AB = br.readLine();
            st = new StringTokenizer(AB, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            //양방향
            adj[A].add(B); 
            adj[B].add(A);
        }

        BFS();
        
        System.out.println(result_num+" "+result_depth+" "+result_count);
    }

    public static void BFS(){
        boolean[] visited = new boolean[N+1];//1부터 시작
        Queue<Info> q = new LinkedList<>();
        
        q.offer(new Info(1, 0));
        visited[1] = true;

        while(!q.isEmpty()){
            Info cur = q.poll();
            
            if(result_depth<cur.depth){
                result_num = cur.num;
                result_depth = cur.depth;
                result_count = 1;
            }else if(result_depth==cur.depth){
                result_num = Math.min(result_num, cur.num);
                result_count++;
            }            

            for(int i=0; i<adj[cur.num].size(); i++){
                int next = adj[cur.num].get(i);    
                if(visited[next]) continue;
                    
                visited[next] = true;
                q.offer(new Info(next, cur.depth+1));
            }
        }
    }

    public static class Info{
        int num;
        int depth;
        public Info(int num, int depth){
            this.num = num;
            this.depth = depth;
        }
    }
}