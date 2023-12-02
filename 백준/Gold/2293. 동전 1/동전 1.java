import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n_k = br.readLine();
        StringTokenizer st = new StringTokenizer(n_k, " ");
        int n = Integer.parseInt(st.nextToken()); //동전개수
        int k = Integer.parseInt(st.nextToken()); //목표금액

        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 입력 끝

        int[] dp = new int[k+1]; //1원부터 시작
        for(int i=0;i<n;i++){ //사용 동전
            for(int j=1;j<=k;j++){ //동전으로 만들고 싶은 가격

                if(coins[i]==j) dp[j]++;

                else if(coins[i]<j){
                    dp[j] += dp[j-coins[i]];
                }
            }

        }

        System.out.println(dp[k]);
    }
}