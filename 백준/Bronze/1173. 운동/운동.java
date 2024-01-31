import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String info = br.readLine();
        StringTokenizer st = new StringTokenizer(info," ");
        
        int N = Integer.parseInt(st.nextToken());//운동 최소시간
        int m = Integer.parseInt(st.nextToken());//최소맥박
        int M = Integer.parseInt(st.nextToken());//최대맥박
        int T = Integer.parseInt(st.nextToken());//맥박증가(운동)
        int R = Integer.parseInt(st.nextToken());//맥박감소(휴식)

        //입력 끝

        int total_time = 0;
        int exercise_time = 0;
        int X = m;//현재맥박
        
        if(m+T<=M){
            while(X>=m && X<=M){
                total_time++;
    
                if(X+T<=M){//운동
                    X+=T;
                    exercise_time++;
                    if(exercise_time == N) break;
                }
                else{//휴식
                    X-=R;
                    if(X<m) X = m;
                }
            }
        }

        if(exercise_time < N) System.out.println(-1);
        else System.out.println(total_time);
    }
}