import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    static Queue<Tomato> pq = new PriorityQueue<>();
    static boolean[][][] visited;
    static int M,N,H,result;
    static int[][][] arr;
    
    static class Tomato implements Comparable<Tomato>{
        int i;
        int j;
        int k;
        int day;//토마토가 얼마나 지나 익었는지
        public Tomato(int i, int j, int k, int day) {
            super();
            this.i = i;
            this.j = j;
            this.k = k;
            this.day = day;
        }
        
        @Override
        public int compareTo(Tomato o) {
            return this.day>o.day?1:-1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();//가로
        N = sc.nextInt();//세로
        H = sc.nextInt();//높이
        
        arr = new int[H][N][M];
        visited = new boolean[H][N][M];
        
        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<M;k++) {
                    arr[i][j][k] = sc.nextInt();
                    
                    //익은 토마토 우선순위 큐에 넣기
                    if(arr[i][j][k] == 1) {
                        pq.add(new Tomato(i,j,k,0));
                        visited[i][j][k] = true;
                    }
                }
            }
        }//for end
        
        //입력 받기 완료
        
        //만약 초장부터 토마토가 다 익어있었다면 0을 출력
        if(growAll()) {
            result=0;
        }else {
            //토마토가 다 안익었으면 익히는 작업 시작
            grow();
            
            //작업 후 안익은 토마토가 존재하면 -1
            if(!growAll()) {
                result = -1;
            }
        }
        
        //결과출력
        System.out.println(result);
    }
    
    //prim algo
    public static void grow() {
        //4방탐색 & 3차원 위 아래 탐색
        int[][] drc = {{0,-1,0},{0,1,0},{0,0,-1},{0,0,1},{-1,0,0},{1,0,0}};//상하좌우 / 3차원 위 아래

        while(!pq.isEmpty()) {
        	
            Tomato cur = pq.poll();
            
            if(result<cur.day) result=cur.day;
            
            for(int d=0;d<6;d++) {
                int nextI = cur.i+drc[d][0];
                int nextJ = cur.j+drc[d][1];
                int nextK = cur.k+drc[d][2];
                
                //범위탐색
                if(nextI<0 || nextI>=H || nextJ<0 || nextJ>=N || nextK<0 || nextK>=M) continue;
                
                if(arr[nextI][nextJ][nextK] == -1) continue;//벽이면 스킵
                
                if(visited[nextI][nextJ][nextK]) continue; //이미 익은 토마토면 스킵
                
                pq.add(new Tomato(nextI,nextJ,nextK,cur.day+1));
                visited[nextI][nextJ][nextK]=true;
            }
        }
    }
    
    public static boolean growAll() {

        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<M;k++) {
                    //토마토가 빈곳이 아닌데, 익지 않았다면 false
                    if(arr[i][j][k]!=-1&&visited[i][j][k] == false) {
                        return false;
                    }
                }
            }
        }//for end
        
        return true;//모두 익었다.
    }
}