import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //최대 백만

        int t = Integer.parseInt(br.readLine());
        
        for(int T=1;T<=t;T++){
            int N = Integer.parseInt(br.readLine()); //배수

            boolean[] number = new boolean[10]; //0~9
            int count = 0; //몇 번째에 0~9를 다 찾는지
            int find = 0; //0~9까지 수를 다 찾았는지
            
            while(true){
                //숫자 문자열
                long numX = N*(count+1);

                while(numX>0){ //현재 숫자에서 나오는 0~9 체크
                    int remain = (int)numX%10;
                    if(!number[remain]){
                        number[remain] = true;
                        find++;
                    }

                    numX/=10;
                    
                }//while
    
                count++;
    
                if(find==10) break;
                
            }//while
    
            System.out.println("#"+T+" "+(N*count));
        }//test
    }
}