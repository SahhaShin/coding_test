import java.util.*;
import java.io.*;

//학생 수는 2n
//각 학생 si의 코딩 역량은 양의 정수 w(si)
//Sm = min{w(Gi) | 1 ≤ i ≤ n}이 최대화 ,  팀 G1, G2, …, Gn
//{1, 7, 5, 8}로 주어졌다면 (8, 1), (7, 5) => 9

//투포인터
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String data = br.readLine();
        StringTokenizer st = new StringTokenizer(data," ");
        
        int[] ability = new int[2*N];
        for(int i=0;i<2*N;i++){
            ability[i] = Integer.parseInt(st.nextToken());
        }

        //입력끝

        Arrays.sort(ability);

        long min = 987654321;
        int S=0;
        int E=2*N-1;
        while(S<2*N/2 && E>=2*N/2){
            if(ability[S]+ability[E]<min) min = ability[S]+ability[E];
            S++;
            E--;
        }

        System.out.println(min);
    }
}