import java.util.*;
import java.io.*;

//DP

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int T=1;T<=t;T++){
            int N = Integer.parseInt(br.readLine());
            
            int[][] score = new int[2][N+1];
            for(int i=0;i<2;i++){
                String scores = br.readLine();
                StringTokenizer st = new StringTokenizer(scores, " ");
                for(int j=1;j<=N;j++){
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N+1];
            dp[0][1] = score[0][1];
            dp[1][1] = score[1][1];

            for(int c=2;c<=N;c++){
                dp[0][c] = Math.max(dp[1][c-1], dp[1][c-2])+score[0][c];
                dp[1][c] = Math.max(dp[0][c-1], dp[0][c-2])+score[1][c];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));

        }//for T
    }
}