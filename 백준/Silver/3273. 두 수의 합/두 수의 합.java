import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String info = br.readLine();
        StringTokenizer st = new StringTokenizer(info," ");

        int[] origin = new int[N];
        for(int i=0; i<N; i++){
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        //입력 끝

        int count = 0;
        int S = 0;
        int E = 1;
        while(S<E && S<N-1){
            if(E>=N){
                S++;
                E=S+1;
            }
            else if(origin[S]+origin[E] == X){
                count++;
                S++;
                E=S+1;
            }
            else E++;
        }

        System.out.println(count);
    }
}