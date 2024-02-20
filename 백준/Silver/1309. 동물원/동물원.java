import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[N][2];
        dp[0][0] = 2;
        dp[0][1] = 3;

        for(int r=1; r<N; r++){
            for(int c=0; c<2; c++){
                if(c==0) dp[r][c] = (dp[r-1][0] + dp[r-1][1])%9901;
                if(c==1) dp[r][c] = (dp[r-1][0] + dp[r][0])%9901;
            }
        }

        System.out.println(dp[N-1][1]);
    }
}