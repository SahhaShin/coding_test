import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        //1. KBS1 찾기
        int pointer = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals("KBS1")) break;
            pointer++;
            sb.append(1);
        }
        list.remove(pointer);
        
        //2. KBS1 올리기
        while(pointer>0){
            pointer--;
            sb.append(4);
        }
        list.add(0,"KBS1");

        //3. KBS2 찾기
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals("KBS2")) break;
            pointer++;
            sb.append(1);
        }
        
        //2. KBS2 올리기
        while(pointer>1){
            pointer--;
            sb.append(4);
        }

        System.out.println(sb);
        
    }
}