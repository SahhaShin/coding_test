import java.util.*;
import java.io.*;

class Main {
    
    static int N;
    static int[] jump;
    static int start;
    static int end;
    static int count = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String jumps = br.readLine();
        StringTokenizer st = new StringTokenizer(jumps," ");
        
        jump = new int[N+1];//1부터 시작
        for(int i=1; i<=N; i++){
            jump[i] = Integer.parseInt(st.nextToken());
        }

        String AToB = br.readLine();
        st = new StringTokenizer(AToB," ");

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        //입력 끝

        if(start == end) System.out.println(0);
        else{
    
            BFS();
            
            if(count == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(count);
        }
    }
    public static void BFS(){
        Queue<Loc> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        
        q.offer(new Loc(start,0));
        visited[start] = true;
        
        while(!q.isEmpty()){
            Loc cur = q.poll();
            
            if(cur.S==end){
                count = Math.min(count, cur.step);
                return;
            }

            //뒤로
            for(int i=(N-cur.S)/jump[cur.S]; i>0; i--){
                if(cur.S+jump[cur.S]*i>0 && cur.S+jump[cur.S]*i<N+1 && !visited[cur.S+jump[cur.S]*i]){
                    q.offer(new Loc(cur.S+jump[cur.S]*i, cur.step+1));
                }
            }

            //앞으로
            for(int i=cur.S/jump[cur.S]; i>0; i--){
                if(cur.S-jump[cur.S]*i>0 && cur.S-jump[cur.S]*i<N+1 && !visited[cur.S-jump[cur.S]*i]){
                    q.offer(new Loc(cur.S-jump[cur.S]*i, cur.step+1));
                }
            }
        }
    }
    public static class Loc implements Comparable<Loc>{
        int S;
        int step;
        
        public Loc(int S, int step){
            this.S = S;
            this.step = step;
        }

        @Override
        public int compareTo(Loc o){
            return this.step>o.step?1:-1;
        }
    }
}