import java.util.*;
import java.io.*;

class Main {
    
    static int[][] drc = {{-1,0}, {1,0},{0,-1},{0,1}};
    static int[][] map, dp;
    static int M,N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String MN = br.readLine();
        StringTokenizer st = new StringTokenizer(MN, " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for(int r=0; r<M; r++){
            String line = br.readLine();
            st = new StringTokenizer(line, " ");
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //입력 끝

        dp = new int[M][N];
        for(int i=0; i<M; i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println(DFS(0, 0));
    }

    public static int DFS(int r, int c){

        if(r==M-1 && c==N-1){
            return 1;
        }

        if(dp[r][c]!=-1){
            return dp[r][c];
        }

        dp[r][c] = 0;//초기화

        for(int d=0; d<4; d++){
            int nextR = r+drc[d][0];
            int nextC = c+drc[d][1];
            
            if(nextR<0 || nextR>=M || nextC<0 || nextC>=N) continue;
            if(map[nextR][nextC]>=map[r][c]) continue;
            
            dp[r][c] += DFS(nextR, nextC);
        }

        return dp[r][c];
    }
}