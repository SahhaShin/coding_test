import java.util.*;
import java.io.*;

//손상된 팀 하나씩 돌면서 앞 팀, 뒤 팀에 카약을 가져온 팀(true false)이 있는지 확인
//앞 뒤 팀 모두 카약이 있다면 앞 팀거 먼저 가져가기 -> 가져가고 false
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NSR = br.readLine();
        StringTokenizer st = new StringTokenizer(NSR, " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        String broken = br.readLine();
        st = new StringTokenizer(broken, " ");
        boolean[] broken_team = new boolean[N+1];
        for(int i=0; i<S; i++){
            int team_no = Integer.parseInt(st.nextToken());
            broken_team[team_no] = true;
        }

        String bring = br.readLine();
        st = new StringTokenizer(bring, " ");
        boolean[] bring_team = new boolean[N+2]; //1~10팀, 0과 N+1팀은 경계
        for(int i=0; i<R; i++){
            int team_no = Integer.parseInt(st.nextToken());

            if(broken_team[team_no]) broken_team[team_no] = false; //자기팀 카약이 손상되었는데, 가져온 경우
            else bring_team[team_no] = true;
        }

        //입력 끝

        int count = 0;

        for(int i=1; i<=N; i++){
            if(!broken_team[i]) continue;

            if(bring_team[i-1]){//앞팀이 가져온 경우
                bring_team[i-1] = false;
            }else if(bring_team[i+1]){//뒤팀이 가져온 경우
                bring_team[i+1] = false;
            }else{
                count++;
            }
        }

        System.out.println(count);
    }
}