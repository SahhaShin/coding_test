import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nm = br.readLine();
        StringTokenizer st = new StringTokenizer(nm, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] baguny = new int[N+1];
        for(int i=1; i<N+1; i++){
            baguny[i] = i;
        }

        for(int i=0; i<M; i++){
            String ab = br.readLine();
            st = new StringTokenizer(ab, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int term = baguny[a];
            baguny[a] = baguny[b];
            baguny[b] = term;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1; i++){
            sb.append(baguny[i]+" ");
        }
        System.out.println(sb);
    }
}