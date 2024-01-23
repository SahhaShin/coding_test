import java.util.*;
import java.io.*;

class Main {
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] map;
    static boolean[][] visited;
    static int R;
    static int C;
    static int sheep;
    static int wolf;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String RC = br.readLine();
        StringTokenizer st = new StringTokenizer(RC," ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        map = new char[R][C];
        for(int r=0;r<R;r++){
            String line = br.readLine();
            for(int c=0;c<C;c++){
                map[r][c] = line.charAt(c);
            }
        }

        //입력 끝

        visited = new boolean[R][C];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(visited[r][c] || map[r][c]!='#') continue;
                BFS(r,c);
            }
        }

        System.out.println(sheep+" "+wolf);

    }

    public static void BFS(int startR, int startC){
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(startR, startC));

        int oCount = 0;
        int vCount = 0;

        while(!q.isEmpty()){
            Loc cur = q.poll();
            
            for(int d=0;d<4;d++){
                int nextR = cur.r+drc[d][0];
                int nextC = cur.c+drc[d][1];
                
                if(nextR<0 || nextR>=R || nextC<0 || nextC>=C) continue;
                if(visited[nextR][nextC]) continue;
                if(map[nextR][nextC]=='#') continue;
                
                visited[nextR][nextC] = true;
                q.offer(new Loc(nextR, nextC));

                if(map[nextR][nextC]=='o') oCount++;
                if(map[nextR][nextC]=='v') vCount++;
            }
        }

        if(oCount>vCount) sheep+=oCount;
        else wolf+=vCount;
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