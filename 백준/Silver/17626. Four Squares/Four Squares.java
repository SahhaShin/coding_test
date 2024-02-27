import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+1];
        dp[1] = 1;

        int pointer = 1;
        for(int i=2; i<=N; i++){
            if((int)Math.pow(pointer+1,2)==i){
                pointer++;
                dp[i] = 1;
                continue;
            }
            
            dp[i] = dp[i - pointer*pointer]+1;
            for(int j=pointer-1; j>=1; j--){
                dp[i] = Math.min(dp[i], dp[i - j*j]+1);
            }
        }

        System.out.println(dp[N]);

    }
}