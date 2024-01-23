import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());

        String cards = br.readLine();
        StringTokenizer st = new StringTokenizer(cards," ");

        int[] card = new int[cardCount+1]; // 인덱스 1부터
        int[] dp = new int[cardCount+1];
        for(int i=1;i<=cardCount;i++){
            card[i] = Integer.parseInt(st.nextToken()); // 지금 이 카드를 가지고 1~N까지 만들거야
            for(int j=i;j<=cardCount;j++){ // 5가지고 1~4를 만들 수는 없다.
                dp[j] = Math.max(dp[j], card[i]+dp[j-i]); //지금까지 계산 vs i카드를 이용해 새롭게 계산
            }
        }

        System.out.println(dp[cardCount]);

    }
}