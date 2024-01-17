import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers," ");

        int[] score = new int[N+1];
        int[] dp = new int[N+1];
        dp[0] = 0;
        int max = 0;
        for(int i=1;i<=N;i++){
            score[i] = Integer.parseInt(st.nextToken());
            for(int j=i-1;j>=1;j--){
                max = Math.max(max, Math.abs(score[i]-score[j])+dp[j-1]);
            }
            dp[i] = max;
        }

        System.out.println(dp[N]);
    }
}