import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nkm = br.readLine();

        StringTokenizer st = new StringTokenizer(nkm," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=1;i<=n;i++){
            dq.addLast(i); //== add
        }

        int direction = 1; // 1:right, 2:left
        int removeNum = 0;//몇개의 숫자가 없어졌는지?
        StringBuilder sb = new StringBuilder();

        int count = 0; //m번이면 없애버림
        while(dq.size() != 0){
            if(direction==1){
                dq.addLast(dq.removeFirst());
                count++;
                if(count==m){
                    count = 0;
                    sb.append(dq.removeLast()).append("\n");
                    removeNum++;
                    if(removeNum%k == 0) direction = 2;
                }
            }else{
                dq.addFirst(dq.removeLast());
                count++;
                if(count==m){
                    count = 0;
                    sb.append(dq.removeFirst()).append("\n");
                    removeNum++;
                    if(removeNum%k == 0) direction = 1;
                }
            }
        }

        //while end

        System.out.println(sb);

    }
}