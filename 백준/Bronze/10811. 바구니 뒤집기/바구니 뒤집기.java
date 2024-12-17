import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nm = br.readLine();
        StringTokenizer st = new StringTokenizer(nm, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] baguny = new int[n+1];
        for(int i=1; i<n+1; i++){
            baguny[i] = i;
        }

        for(int i=0; i<m; i++){
            String ab = br.readLine();
            st = new StringTokenizer(ab, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            while(a < b){
                int term = baguny[a];
                baguny[a] = baguny[b];
                baguny[b] = term;
                a++;
                b--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            sb.append(baguny[i]+" ");
        }

        System.out.println(sb);
    }
}