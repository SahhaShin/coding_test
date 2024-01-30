import java.util.*;
import java.io.*;

class Solution {
    static int[][] drcPlus = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //상하좌우
    static int[][] drcX = {{-1,-1},{1,1},{-1,1},{1,-1}}; //좌상 우하 우상 우하
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T<=t; T++){

            String NM = br.readLine();
            StringTokenizer st = new StringTokenizer(NM," ");

            N =  Integer.parseInt(st.nextToken());//크기
            M =  Integer.parseInt(st.nextToken())-1;//분사력

            map = new int[N][N];

            for(int r=0; r<N; r++){
                String info = br.readLine();
                st = new StringTokenizer(info, " ");

                for(int c=0; c<N; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            //입력 끝

            int max = 0;
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    int countPlus = Plus(r, c);
                    int countX = X(r, c);

                    max = Math.max(max, countPlus);
                    max = Math.max(max, countX);
                }
            }

            System.out.println("#"+T+" "+max);
            
        }//test
    }

    public static int Plus(int startR, int startC){
        int total = 0;
        
        for(int d=0;d<4;d++){
            for(int c=1; c<=M; c++){
                int nextR = startR + drcPlus[d][0]*c;
                int nextC = startC + drcPlus[d][1]*c; 

                if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) break;
                total+=map[nextR][nextC];
            }
        }

        return total + map[startR][startC];
    }

    public static int X(int startR, int startC){
        int total = 0;
        
        for(int d=0;d<4;d++){
            for(int c=1; c<=M; c++){
                int nextR = startR + drcX[d][0]*c;
                int nextC = startC + drcX[d][1]*c; 

                if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) break;
                total+=map[nextR][nextC];
            }
        }

        return total + map[startR][startC];
    }
}