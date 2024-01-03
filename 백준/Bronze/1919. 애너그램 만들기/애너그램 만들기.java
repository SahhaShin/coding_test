import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] count1 = new int[26]; //26개의 소문자
        int[] count2 = new int[26]; //26개의 소문자

        for(int i=0;i<str1.length();i++){
            int next = str1.charAt(i)-'a';
            count1[next]++;
        }

        for(int i=0;i<str2.length();i++){
            int next = str2.charAt(i)-'a';
            count2[next]++;
        }

        int sameCount = 0;
        for(int i=0;i<str1.length();i++){
            if(count2[str1.charAt(i)-'a']>0){
                sameCount++;
                count2[str1.charAt(i)-'a']--;
            }
        }

        int result = str1.length()-sameCount + str2.length()-sameCount;

        System.out.println(result);
    }
}