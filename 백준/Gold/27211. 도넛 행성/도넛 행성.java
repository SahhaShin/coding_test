import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();

        StringTokenizer st = new StringTokenizer(NM, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++){
            String info = br.readLine();
            st = new StringTokenizer(info, " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //입력 끝

        int count = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    BFS(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void BFS(int startR, int startC){
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(startR,startC));
        map[startR][startC] = 1;

        while(!q.isEmpty()){
            Loc cur = q.poll();

            for(int d=0; d<4; d++){
                int nextR = cur.r + drc[d][0];
                int nextC = cur.c + drc[d][1];

                if(nextR>=N) nextR %= N;
                if(nextR<0) nextR += N;
                if(nextC>=M) nextC %= M;
                if(nextC<0) nextC += M;

                if(map[nextR][nextC]!=0) continue;

                q.offer(new Loc(nextR, nextC));
                map[nextR][nextC] = 1;
            }
        }
    }

    public static class Loc{
        int r;
        int c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}