import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] numberList = new int[N];
        for(int i=0;i<N;i++){
            numberList[i] = Integer.parseInt(st.nextToken());
        }

        //입력 끝

        //투포인터
        //해당 리스트의 연속 수열의 합이 특정 값을 가지는 것을 확인하는 문제

        int E = 0; //끝 인덱스
        int sum = 0;
        int result = 0;

        //1 ≤ N ≤ 10,000
        for(int S=0; S<N; S++){ //시작 인덱스

            
            while(sum<M && E<N){
                sum += numberList[E];
                E++; //마지막에 E++를 해주기 때문에 E<=N해주면 안됨
            }
            
            if(sum==M){
                result++;
            }

            //while에서 나온 이상(커서 나왔으니까) S를 무조건 전진해야함
            sum -= numberList[S];

        }

        System.out.println(result);

    }
}