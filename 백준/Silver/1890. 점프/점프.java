import java.util.*;
import java.io.*;

class Main {
    static int[][] drc = {{0,1},{1,0}};//우 하
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int r=0;r<N;r++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            for(int c=0;c<N;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //입력 끝

        long[][] mem = new long[N][N];
        mem[0][0] = 1;
        
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(r==N-1 && c==N-1) continue;
                if(mem[r][c]==0) continue; //아예 0인 곳은 길을 만들 수 없으니 안가네
                for(int d=0;d<2;d++){
                    int nextR = r+drc[d][0]*map[r][c];
                    int nextC = c+drc[d][1]*map[r][c];

                    if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) continue;
                    
                    mem[nextR][nextC]+=mem[r][c]; //새로운 길이 생기는 게 아니라 이전에 왔던 길 갯수만큼 오는 거
                }
            }
        }

        System.out.println(mem[N-1][N-1]);
    }
}