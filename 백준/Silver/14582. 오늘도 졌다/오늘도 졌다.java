import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String team1 = br.readLine();
        String team2 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(team1," ");
        StringTokenizer st2 = new StringTokenizer(team2," ");

        int[] score_team1 = new int[9];
        int[] score_team2 = new int[9];
        for(int i=0;i<9;i++){
            score_team1[i] = Integer.parseInt(st1.nextToken());
            score_team2[i] = Integer.parseInt(st2.nextToken());
        }

        //입력 끝

        int total_team1 = 0;
        int total_team2 = 0;
        boolean flag = false;
        for(int i=0;i<9;i++){
            total_team1+=score_team1[i];
            if(total_team1>total_team2){
                flag = true;
                break;
            }
            total_team2+=score_team2[i];
        }//for i

        if(flag) System.out.println("Yes");
        else System.out.println("No");
    }
}