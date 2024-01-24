import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //자릿수 최대 1000자리

        int[][] dp = new int[N+1][10]; //행 : 자릿수, 열 : 0~9
        Arrays.fill(dp[0],1);
        
        for(int r=1;r<=N;r++){
            for(int c=0; c<=9; c++){
               for(int k=0;k<=c;k++){
                   dp[r][c] += dp[r-1][k];
                   dp[r][c] %= 10007;
               }
            }
           
        }
        
        System.out.println(dp[N][9] % 10007);
    }
}