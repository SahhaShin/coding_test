import java.util.*;
import java.io.*;

//투포인터
//주의점 모두 중복인 접시를 먹는 경우도 있음 중복인 경우를 무조건 빼지 말 것
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NDKC = br.readLine();
        StringTokenizer st = new StringTokenizer(NDKC," ");
        
        int N = Integer.parseInt(st.nextToken());//접시수
        int D = Integer.parseInt(st.nextToken());//초밥가짓수
        int K = Integer.parseInt(st.nextToken());//연속접시수
        int C = Integer.parseInt(st.nextToken());//쿠폰번호

        int[] trail = new int[N];
        for(int i=0;i<N;i++){
            trail[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int S=0;S<N;S++){
            boolean[] sel = new boolean[D+1];//최대 접시 번호는 3천까지 나옴
            int[] combination = new int[K];
            int count = 0;
            
            for(int E=S;E<S+K;E++){
                if(!sel[trail[E%N]]){
                    count++;
                    sel[trail[E%N]] = true;
                }
                combination[E-S] = trail[E%N];
            }
            if(sel[C]) result=Math.max(result,count);
            else result=Math.max(result,count+1);
        }

        System.out.println(result);
    }
}