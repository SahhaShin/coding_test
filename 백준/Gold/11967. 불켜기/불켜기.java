import java.util.*;
import java.io.*;

class Main {

    static int N;
    static List<Location>[][] map;
    static Queue<Location> onList = new LinkedList<>(); //불 켜진 곳만 있음
    static boolean[][] onoff; //이미 켜진 불인지 확인용
    static boolean[][] visited; //DFS 방문 체크용
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1][N+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<N+1;j++){
                map[i][j] = new ArrayList<>();
            }
        }

        onoff = new boolean[N+1][N+1]; // 1부터 시작
        onoff[1][1] = true;//언제나 (1,1)은 시작점
        
        for(int i=0;i<M;i++){
            String xyab = br.readLine();
            st = new StringTokenizer(xyab," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[x][y].add(new Location(a,b));
        }

        BFS();
        
        System.out.println(result+1);//이미 켜져있는 (1,1) 포함
        br.close();
    }

    public static void BFS(){
        Queue<Location> q = new LinkedList<>();//갈 수 있는 경로
        q.offer(new Location(1,1));

        while(!q.isEmpty()){
            Location newLoc = q.poll();

            if(newLoc.x==1 && newLoc.y==1) {
                visited = new boolean[N+1][N+1];
                visited[1][1] = true;
            }

            //불켜기
            for(int i=0;i<map[newLoc.x][newLoc.y].size();i++){
                Location next = map[newLoc.x][newLoc.y].get(i);

                if(onoff[next.x][next.y]) continue; //이미 켜져있는 건 패스

                onoff[next.x][next.y] = true;
                result++;

                if(newLoc.x!=1 || newLoc.y!=1) q.offer(new Location(1,1));
            }

            //다음으로 이동(큐에 넣기)
            for(int d=0;d<4;d++){
                int nextX = newLoc.x + drc[d][0];
                int nextY = newLoc.y + drc[d][1];

                if(nextX<0 || nextX>=N+1 || nextY<0 || nextY>=N+1) continue; //경계체크
                if(visited[nextX][nextY]) continue;
                if(!onoff[nextX][nextY]) continue; //불이 켜져있지 않으면 안됨
                
                visited[nextX][nextY] = true;
                q.offer(new Location(nextX, nextY));
            }
            
        }
        
    }

    public static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}