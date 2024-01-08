import java.util.*;
import java.io.*;

class Main {
    
    static int N;
    static int M;
    static int P;
    static Queue<Loc>[] q;
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[] move;
    static int[] castle;
    static char[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NMP = br.readLine();
        StringTokenizer st = new StringTokenizer(NMP, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        String moves = br.readLine();
        st = new StringTokenizer(moves," ");

        q = new LinkedList[P+1];
        move = new int[P+1];//1부터 시작
        for(int i=1;i<=P;i++){
            move[i] = Integer.parseInt(st.nextToken());
            q[i] = new LinkedList<>();
        }

        map = new char[N][M];
        castle = new int[P+1];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = line.charAt(j);
                if(map[i][j]-'0'>=1 && map[i][j]-'0'<=9){
                    q[map[i][j]-'0'].offer(new Loc(i, j));
                    castle[map[i][j]-'0']++;
                }
            }
        }

        BFS();

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=P;i++){
            sb.append(castle[i]).append(" ");
        }

        System.out.println(sb);
        
    }

    public static void BFS(){
        
        while(true){
            for(int p=1;p<=P;p++){//지금 누구?
                for(int time=1;time<=move[p];time++){//몇 칸 이동?
                    int size = q[p].size();
                    for(int i=0;i<size;i++){//현재 사람이 가진 성 갯수
                        Loc cur = q[p].poll();
                        for(int d=0;d<4;d++){//4방 탐색
                            int nextX = cur.x+drc[d][0];
                            int nextY = cur.y+drc[d][1];
                            if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue;
                            if(map[nextX][nextY]=='.'){
                                q[p].offer(new Loc(nextX, nextY));
                                map[nextX][nextY] = map[cur.x][cur.y];
                                castle[map[nextX][nextY]-'0']++;
                            }
                        }// for d
                    }// for size
                    if(q[p].isEmpty()) break;
                }// for time
            }// for p

            //모든 q가 비어있으면 종료
            boolean flag = false;
            for(int p=1;p<=P;p++){
                if(q[p].size()>0) {
                    flag=true; //즉 하나라도 큐에 뭐가 있으면 돌아가
                    break;
                }
            }
            if(!flag) break;
        }//while true
    }
    

    public static class Loc{
        int x;
        int y;
        public Loc(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}