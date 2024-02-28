import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String NSM = br.readLine();
        StringTokenizer st = new StringTokenizer(NSM, " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String Vs = br.readLine();
        st = new StringTokenizer(Vs, " ");
        int[] V = new int[N+1];
        for(int i=1; i<=N; i++){
            V[i] = Integer.parseInt(st.nextToken());
        }

        //입력 끝

        int[] dp = new int[M+1];
        Arrays.fill(dp, -1);
        dp[S] = 0;
        int result = -1;

        for(int n=1; n<=N; n++){
            List<Integer> change = new ArrayList<>();
            for(int m=0; m<=M; m++){
                if(dp[m]==n-1){
                    int plus = m+V[n];
                    int minus = m-V[n];

                    if(plus<=M) change.add(plus);
                    if(minus>=0) change.add(minus);
                    
                }
            }

            for(int i=0; i<change.size(); i++){
                int change_idx = change.get(i);
                dp[change_idx] = n;
                if(n==N) result = Math.max(result, change_idx);
            }
        }
        System.out.println(result);
    }
}