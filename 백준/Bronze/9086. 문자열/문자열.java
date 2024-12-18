import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<t; i++){
            char[] word = br.readLine().toCharArray();

            sb.append(word[0]);
            sb.append(word[word.length-1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}