import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[31];

        for(int i=0; i<28; i++){
            int n = Integer.parseInt(br.readLine());
            num[n]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<31; i++){
            if(num[i] == 0){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb);
    }
}