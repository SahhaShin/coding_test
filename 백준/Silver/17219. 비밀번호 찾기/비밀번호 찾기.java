import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> memo = new HashMap<>();
        for(int i=0;i <N; i++){
            String info = br.readLine();
            st = new StringTokenizer(info," ");
            String site = st.nextToken();
            String pw = st.nextToken();

            memo.put(site, pw);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String site = br.readLine();
            String pw = memo.get(site);
            sb.append(pw).append("\n");
        }

        System.out.println(sb);
    }
}