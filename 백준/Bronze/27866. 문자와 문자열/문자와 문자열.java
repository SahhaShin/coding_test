import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] word = br.readLine().toCharArray();
        int num = Integer.parseInt(br.readLine());
        
        System.out.println(word[num-1]);
    }
}