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

        for(int count=0; count<M; count++){
            String ijk = br.readLine();
            st = new StringTokenizer(ijk, " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(int a = i; a < j+1; a++){
                baguny[a] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int count=1; count<N+1; count++){
            sb.append(baguny[count]+" ");
        }
        System.out.println(sb);
    }
}