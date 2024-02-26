import java.util.*;
import java.io.*;

class Main {

    static int N;
    static List<Integer>[] student_like;
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] map;
    static PriorityQueue<Loc> pq;
    static int[] score = {0, 1, 10, 100, 1000};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        student_like = new ArrayList[N*N+1];
        for(int i=0; i<N*N+1; i++){
            student_like[i] = new ArrayList<>();
        }

        for(int i=0; i<N*N; i++){
            String info = br.readLine();
            StringTokenizer st = new StringTokenizer(info," ");
            
            int student_no = Integer.parseInt(st.nextToken());
            for(int j=0; j<4; j++){
                student_like[student_no].add(Integer.parseInt(st.nextToken()));
            }

            pq = new PriorityQueue<>();
            PickPlace(student_no); //현재 대상 학생 자리 정하기
            
            Loc target = pq.poll();
            int r = target.r;
            int c = target.c;
            map[r][c] = student_no;
        }
        
        int total = 0;
        for(int r=1; r<=N; r++){
            for(int c=1; c<=N; c++){
                int adj = AdjCount(r, c);
                total+=score[adj];
            }
        }

        System.out.println(total);
    }

    public static void PickPlace(int student_no){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){

                if(map[i][j] != 0) continue;
                
                int like_count = 0;
                int blank_count = 0;
                for(int d=0; d<4; d++){
                    int nextR = i+drc[d][0];
                    int nextC = j+drc[d][1];
                    if(nextR<=0 || nextR>N || nextC<=0 || nextC>N) continue;
                    if(map[nextR][nextC] == 0) blank_count++;

                    for(int a=0; a<4; a++){
                        if(map[nextR][nextC] == student_like[student_no].get(a)){
                            like_count++;
                            break;
                        }
                    }
                }

                pq.offer(new Loc(like_count, blank_count, i, j));
            }
        }
    }

    public static int AdjCount(int r, int c){
        int like_count = 0;

        for(int d=0; d<4; d++){
            int nextR = r+drc[d][0];
            int nextC = c+drc[d][1];
            if(nextR<=0 || nextR>N || nextC<=0 || nextC>N) continue;

            for(int a=0; a<4; a++){
                if(map[nextR][nextC] == student_like[map[r][c]].get(a)){
                    like_count++;
                    break;
                }
            }
        }

        return like_count;
    }

    public static class Loc implements Comparable<Loc>{
        int like_count = 0;
        int blank_count = 0;
        int r;
        int c;

        public Loc(int like_count, int blank_count, int r, int c){
            this.like_count = like_count;
            this.blank_count = blank_count;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Loc o){
            if(this.like_count<o.like_count) return 1;
            else if(this.like_count>o.like_count) return -1;
            else{
                if(this.blank_count<o.blank_count) return 1;
                else if(this.blank_count>o.blank_count) return -1;
                else{
                    if(this.r>o.r) return 1;
                    else if(this.r<o.r) return -1;
                    else return this.c>o.c?1:-1;
                }
            }
        }
    }
}