import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String word = "";
        
        while((word = br.readLine())!=null){
            sb.append(word+"\n");
        }
        System.out.println(sb);
    }
}