import java.util.*;
import java.io.*;

class Main {
    static List<Integer>[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        friends = new ArrayList[N+1];//1부터 시작
        for(int i=0;i<N+1;i++){
            friends[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            String ab = br.readLine();
            StringTokenizer st = new StringTokenizer(ab, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        int result = 0;
        boolean[] sel = new boolean[N+1]; //1부터 시작
        sel[1] = true; //1은 주최자이기 때문에 포함 x
        
        for(int i=0;i<friends[1].size();i++){//친구
            
            int curF = friends[1].get(i);
            
            if(!sel[curF]){
                result++;
                sel[curF] = true;
            }
            
            for(int j=0;j<friends[curF].size();j++){//친구의 친구
                int FF = friends[curF].get(j);

                if(!sel[FF]){
                    result++;
                    sel[FF] = true;
                }
            }
        }

        System.out.println(result);
    }
}