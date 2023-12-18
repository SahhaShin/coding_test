import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Main {

    static List<Node> birusList = new ArrayList<>();
    static Node[] birusSel;
    
    static int[][] map;
    static boolean[][] visited;
    
    static int N;
    static int M;

    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static int time = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        birusSel = new Node[M];
        
        for(int i=0;i<N;i++){ //map 입력 
            String line = br.readLine();
            st = new StringTokenizer(line, " ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j]==2) 
                    birusList.add(new Node(i,j,0));//바이러스 저장
            }
        }

        //입력 끝

        Combination(0, 0);

        if(time==Integer.MAX_VALUE) time = -1;
        
        System.out.println(time);
    }

    //바이러스 위치 조합
    public static void Combination(int depth, int c){
        if(depth==M){
            visited = new boolean[N][N];
            Spread();
            return;
        }

        if(c==birusList.size()) return;

        birusSel[depth] = birusList.get(c);
        Combination(depth+1, c+1);
        Combination(depth, c+1);
    }

    //바이러스 퍼뜨리기
    public static void Spread(){

        Queue<Node> birus = new LinkedList<>();
        for(int i=0;i<M;i++){
            birus.offer(birusSel[i]);
            visited[birusSel[i].r][birusSel[i].c] = true;
        }
        
        int calTime = 0;

        while(!birus.isEmpty()){
            Node curBirus = birus.poll();
            if(calTime<curBirus.time) calTime = curBirus.time;

            for(int d=0;d<4;d++){
                int nextR = curBirus.r+drc[d][0];
                int nextC = curBirus.c+drc[d][1];

                if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) continue;

                if(!visited[nextR][nextC] && map[nextR][nextC]!=1){
                    birus.offer(new Node(nextR,nextC,curBirus.time+1));
                    visited[nextR][nextC]=true;
                }
            }
        }

        if(!Blank()){//빈칸 없으면 갱신
            time = Math.min(time,calTime);   
        }
        
    }

    //빈칸 있는지 확인
    public static boolean Blank(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j]!=1){
                    return true;
                }
            }
        }
        return false;
    }

    public static class Node{
        int r;
        int c;
        int time;
        
        public Node(int r, int c, int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }
    }
}