import java.util.*;
import java.io.*;

//가장 길이가 짧은 체인 순으로 고리 해체
//고리로 2개의 체인 연결 -2 (처음에만 -2이지, 그 다음부터는 1개씩 추가 연결)
//하나의 체인을 연결로 다 쓰면 -1

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String counts = br.readLine();
        StringTokenizer st = new StringTokenizer(counts, " ");

        int[] chains = new int[N];
        for(int i=0;i<N;i++){
            chains[i] = Integer.parseInt(st.nextToken());
        }

        //입력 끝

        Arrays.sort(chains);

        int count = N;
        int target = 0; //현재 해체중인 가장 작은 체인
        long use = 0; //1 ≤ Li ≤ 1000000, 2 ≤ N ≤ 500000
        
        while(count>0){
            
            //1. 하나를 써서 연결
            if(chains[target]>0){
                chains[target]--;
                use++;
                if(count==N) count-=1; //2. 고리로 2개의 체인 연결 -2(아래 count-1 합쳐서)
                count-=1; //2. 처음 이후는 -1
                

                //3. 하나의 체인을 연결로 다 쓰면 -1
                if(chains[target]<=0){
                    count--;
                    target++;
                }
            }
            
        }//while end

        System.out.println(use);
        
    }
}