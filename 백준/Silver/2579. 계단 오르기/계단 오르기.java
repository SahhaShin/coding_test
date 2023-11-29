import java.io.*;

public class Main {

    static int[] dp;
    static int[] floor_list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int floor_count = Integer.parseInt(br.readLine());

        floor_list = new int[floor_count];
        for(int i=0;i<floor_count;i++){
            int score = Integer.parseInt(br.readLine());
            floor_list[i] = score;
        }

        dp = new int[floor_count];
        dp[0] = floor_list[0];
        if(floor_count>=2) dp[1] = floor_list[0]+floor_list[1];

        if(floor_count>=3) dp[2] = Math.max(floor_list[0], floor_list[1])+floor_list[2];
        
        System.out.println(find(floor_count-1));
    }

    public static int find(int N){ //N까지의 최대값을 계산

        if(dp[N]==0)
            dp[N] = Math.max(floor_list[N-1]+find(N-3), find(N-2))+floor_list[N];
        
        return dp[N];

    }
}