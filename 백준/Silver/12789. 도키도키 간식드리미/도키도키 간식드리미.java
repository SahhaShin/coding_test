import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String info = br.readLine();
        StringTokenizer st = new StringTokenizer(info," ");
        
        Stack<Integer> ready = new Stack<>();
        int order = 1;//받을 차례

        boolean flag = true;
        for(int i=0; i<N; i++){

            //대기줄에서 받을 수 있는지 확인
            while(!ready.isEmpty() && ready.peek() == order){
                    ready.pop();
                    order++;
            }
            
            int next = Integer.parseInt(st.nextToken());
            if(order == next) order++; //통로에서 받을 수 있는지 확인
            else if(ready.isEmpty() || ready.peek() > next) ready.add(next);
            else{
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("Nice");
        else System.out.println("Sad");
    }
}