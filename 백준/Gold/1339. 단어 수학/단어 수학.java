import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //2

        int[] alpha_list = new int[26];//각 알파벳은 어떤 자릿수를 가지고 있는지 확인

        for(int i=0; i<N; i++){
            String sentence = br.readLine();//AAA

            int position10 = (int)Math.pow(10, sentence.length()-1);
            
            for(int j=0;j<sentence.length();j++){
                
                int alpha = sentence.charAt(j)-65;

                alpha_list[alpha] += position10; //특정 알파벳이 가지는 모든 자릿수를 더해준다.
                position10/=10;
            }
        }

        Arrays.sort(alpha_list);

        int num = 9;
        int sum = 0;
        for(int i=25; i>=0; i--){
            sum+=alpha_list[i]*num;
            num--;
        }

        System.out.println(sum);
    }
}