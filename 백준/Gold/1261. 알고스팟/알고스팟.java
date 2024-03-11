import java.util.*;
import java.io.*;

class Main {
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");
        N = Integer.parseInt(st.nextToken());   
        M = Integer.parseInt(st.nextToken());    

        map = new int[M][N];
        for(int i=0; i<M; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }

        //입력 끝
        
        System.out.println(BFS());

    }

    public static int BFS(){
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[M][N];
        pq.offer(new Loc(0,0,map[0][0]));
        visited[0][0] = true;
        
        while(true){
            Loc cur = pq.poll();
            if(cur.r == M-1 && cur.c == N-1) return cur.break_wall;

            for(int d=0; d<4; d++){
                int nextR = cur.r + drc[d][0];
                int nextC = cur.c + drc[d][1];

                if(nextR<0 || nextR>=M || nextC<0 || nextC>=N) continue;
                if(visited[nextR][nextC]) continue;

                if(map[nextR][nextC] == 0)
                    pq.offer(new Loc(nextR, nextC, cur.break_wall));
                   
                if(map[nextR][nextC] == 1)
                    pq.offer(new Loc(nextR, nextC, cur.break_wall+1));

                visited[nextR][nextC] = true;
            }
        }
    }

    public static class Loc implements Comparable<Loc>{
        int r;
        int c;
        int break_wall;
        public Loc(int r, int c, int break_wall){
            this.r = r;
            this.c = c;
            this.break_wall = break_wall;
        }

        public int compareTo(Loc o){
            return this.break_wall>o.break_wall?1:-1;
        }
    }
}