import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int T=1;T<=t;T++){
            int day = sc.nextInt();
            long[] fee = new long[day];
            for(int i=0;i<day;i++){
                fee[i] = sc.nextInt();
            }
    
            //1. 맨 끝 날짜를 max로 시작
            long max = fee[day-1];
    
            //2. 끝에서부터 돌면서 max보다 작으면 이득에 더해주고, max보다 크면 max를 교체한다.
            long result = 0;
            for(int d=day-1;d>=0;d--){
                if(fee[d]<=max) result += max-fee[d];
                else max = fee[d];
            }
            
            System.out.println(result);
        }
    }
}