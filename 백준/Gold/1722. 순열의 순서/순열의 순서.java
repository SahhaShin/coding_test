import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long[] factorial;
    static int N;
    static boolean[] sel;
    
     public static void main(String[] args) throws IOException, NumberFormatException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        //팩토리얼 구하기
        factorial = new long[N+1]; //1!부터 시작
        Factorial(N);

        sel = new boolean[N+1]; //1부터 시작

        
        String commands = br.readLine();
        StringTokenizer st = new StringTokenizer(commands, " ");
        
        int command = Integer.parseInt(st.nextToken());
        
        if(command==1){ //순열구하기 ex) 1 3 2 4
            long order = Long.parseLong(st.nextToken());
            
            numberInfo[] numbers = new numberInfo[N+1];

            for(int i=1;i<=N;i++){//몇번째 자리?
                for(int j=N;j>=1;j--){//무슨 숫자? 뒤에서 부터 살펴주다가 처음 알맞은 숫자 pick!

                    if(sel[j]) continue;

                    int prev_num=prev_num_check(j);
                    long prevCount = factorial[N-i]*prev_num;

                    if(prevCount<order){//해당 숫자는 들어갈 수 있음

                        numbers[i] = new numberInfo(j, order-prevCount);
                        sel[j] = true;
                        order = order-prevCount;
                        break;

                    }
                }
            }

            for(int i=1;i<=N;i++){
                System.out.printf(numbers[i].num+" ");
            }

        }else if(command==2){//이 순열은 몇 번째?

            int[] inputNumbers = new int[N];
            for(int i=0;i<N;i++){
                inputNumbers[i] = Integer.parseInt(st.nextToken());
            }

            long prevCount = 0; //가짓수
            for(int i=0;i<N;i++){ //정답 이전에 나올 수 있는 모든 가짓수를 체크
                int prev_num=prev_num_check(inputNumbers[i]);
                prevCount+=factorial[(N-(i+1))]*prev_num;
                sel[inputNumbers[i]] = true;
            }

            // 정답 이전에 나올 수 있는 모든 가짓수를 체크했으므로 그 다음 순서(+1)가 정답
            System.out.println(prevCount+1);

        }

    }

    public static void Factorial(int N){

        factorial[0] = 1;
        factorial[1] = 1;

        for(int i = 2; i <= N; i++){
            factorial[i] = factorial[i-1] * i;
        }

    }

    public static int prev_num_check(int target){ //타겟 수 앞에 수가 몇 개가 있는지?
        int count = 0;
        for(int i=1;i<target;i++){
            if(!sel[i]) count++;
        }

        return count;
    }

    public static class numberInfo{
        int num;
        long remainNum;

        public numberInfo(int num, long remainNum){
            this.num = num;
            this.remainNum = remainNum;
        }
    }
    
}