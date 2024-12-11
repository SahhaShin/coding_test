import java.util.*;
import java.lang.*;
import java.io.*;

/* 로직 설명
* 6까지의 배열에 같은 수 count
* for문으로 돌다가 3, 2 count가 있으면 상금 계산 -> break
* 1개 이상이 있을 때마다 수를 저장하다가 마지막까지 동일 수가 있는게 없다면 상금 계산
*/

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[7]; //1~6
        int pay = 0;
        int hasCountNum = 0;
        boolean hasSameNum = false;
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers, " ");

        while(st.hasMoreTokens()){
            count[Integer.parseInt(st.nextToken())]++;
        }

        for(int i=1; i<7; i++){
            if(count[i]>=3){
                pay = 10000+(i*1000);
                hasSameNum = true;
                break;
            }else if(count[i]>=2){
                pay = 1000+(i*100);
                hasSameNum = true;
                break;
            }else if(count[i]>=1){
                hasCountNum = i;
            }
        }

        if(!hasSameNum) pay = hasCountNum*100;
        
        System.out.println(pay);
    }
}