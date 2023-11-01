import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        if(n>=2)dp[2] = 1;
        if(n>=4)dp[4] = 2;
        if(n>=5)dp[5] = 1;

        for(int i=6;i<n+1;i++){

            if(i>2){
                if(dp[i-2]==0) continue;
                dp[i] = dp[i-2]+1;
            }
            
            if(i>5) {
                if(dp[i-5]==0) continue;
                dp[i] = Math.min(dp[i], dp[i-5]+1);
            }
        }

        if(dp[n]==0) System.out.println(-1);
        else System.out.println(dp[n]);
    }
    
}