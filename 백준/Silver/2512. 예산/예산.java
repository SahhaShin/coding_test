import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static long result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//지방의 수
        int[] fee = new int[n];//각 지방 요청 예산

        for(int i=0;i<n;i++){
            fee[i] = sc.nextInt();
        }
        
        long limit = sc.nextInt();//총 예산

        //1. fee는 sort (작은~큰)
        Arrays.sort(fee);

        //2. 전체 합 구하기
        long total = 0;
        for(int i=0;i<n;i++){
            total += fee[i];
        }

        //2. 전체합이 총 예산을 넘는가?
        int startHigh = fee[n-1]; //시작 상한액
        if(total==limit){//안넘는다.
            result = fee[n-1];
        }
        else if(total>limit){ //limit이 더 작다면?
            result = fee[n-1];
        }
        else{//넘는다.
            //가장 큰 애 전부터 fit한 친구 찾기
            for(int i=n-1;i>=0;i--){
                int curFee = fee[i];
                long curTotal = 0;//현재 상한점이라고 쳤을 때 총액

                for(int j=0;j<n;j++){
                    if(fee[j]<=curFee){
                        curTotal += fee[j]; 
                    }else{
                        curTotal += curFee;
                    }
                }

                if(curTotal>limit) continue;
                else{
                    startHigh = curFee;
                    result = curFee; //현재 최고액
                    break;
                }
            }
        }


        //3. 시작 상한액이 정해졌다. fee[n-1]-1이 되기 전까지 가보자고
        if(total>limit){
            for(int i = fee[n-1]; i>=0 ; i--){
                int curHight = i; //현재 상한가
                long curTotal = 0;

                for(int j=0;j<n;j++){
                    if(fee[j]<=curHight){
                        curTotal += fee[j]; 
                    }else{
                        curTotal += curHight;
                    }
                }
    
                if(curTotal>limit) continue;
                else{
                    result = curHight; //현재 최고액
                    break;
                }
            }
        }
        else if(total<limit){

            for(int i=startHigh; i<fee[n-1]; i++){
                int curHight = i; //현재 상한가
                long curTotal = 0;
    
                for(int j=0;j<n;j++){
                    if(fee[j]<=curHight){
                        curTotal += fee[j]; 
                    }else{
                        curTotal += curHight;
                    }
                }
    
                if(curTotal>limit) break;
                else{
                    result = curHight; //현재 최고액
                }
            }
        }
        System.out.println(result);
    }
    
}