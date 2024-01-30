import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[][] map;
    static List<Loc> core;
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static int max_conn;
    static int min_len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int T=1; T<=t; T++){

            //초기화
            max_conn = 0;
            min_len = 987654321;
            core = new ArrayList<>();

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for(int r=0; r<N; r++){
                String info = br.readLine();
                StringTokenizer st = new StringTokenizer(info, " ");
                for(int c=0; c<N; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());

                    //core 위치
                    if((r!=0 && c!=0 && r!=N-1 && c!=N-1) && map[r][c]==1){
                        core.add(new Loc(r, c));
                    }
                }
            }

            //입력 끝

            Permutation(0, 0, 0);

            System.out.println("#"+T+" "+min_len);
        }//test
    }

    public static void Permutation(int depth, int conn, int len){

        if(depth == core.size()){
            
            if(max_conn<conn){
                min_len = len;
                max_conn = conn;
            }
            
            if(max_conn==conn){
                if(min_len>len){
                    min_len = len;
                    max_conn = conn;
                }
            }
            
            return;
        }

        
        for(int d=0;d<4;d++){
            if(FillPossible(d, core.get(depth).r, core.get(depth).c)){
                int count = Fill(d, core.get(depth).r, core.get(depth).c, 2); //그리기
                Permutation(depth+1, conn+1, len+count);
                Fill(d, core.get(depth).r, core.get(depth).c, 0); //지우기
            }
        }
        Permutation(depth+1, conn, len); //선택 안함
    }

    public static boolean FillPossible(int d, int startR, int startC){
        
        int count = 1;
        while(true){
            int nextR = startR + drc[d][0]*count;
            int nextC = startC + drc[d][1]*count;
            if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) return true;//연결 가능
            if(map[nextR][nextC]!=0) return false; //연결 불가능

            count++;
        }
        
    }

    public static int Fill(int d, int startR, int startC, int num){
        
        int count = 1;
        while(true){
            int nextR = startR + drc[d][0]*count;
            int nextC = startC + drc[d][1]*count;

            if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) break;

            map[nextR][nextC] = num;

            count++;
        }

        return count-1;
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