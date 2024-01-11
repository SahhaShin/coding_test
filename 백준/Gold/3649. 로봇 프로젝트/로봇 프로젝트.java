import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String testcase = "";
        while((testcase=br.readLine())!=null){
            int cmTnm = Integer.parseInt(testcase)* 10000000;
            int N = Integer.parseInt(br.readLine());

            int[] lego = new int[N];
            for(int i=0;i<N;i++){
                lego[i] = Integer.parseInt(br.readLine());
            }
    
            //입력 끝
    
            //1. sort
            Arrays.sort(lego);
    
            //2. l1 <= l2를 찾아라
            boolean flag = false;
            int S = 0;
            int E = N-1;
            
            while(S<E){
                int sum = lego[S]+lego[E];
                if(sum==cmTnm){
                    flag=true;
                    break;
                }
                else if(sum<cmTnm) S++;
                else E--;
                
            }
    
            if(flag){
                if(flag) System.out.println("yes "+lego[S]+" "+lego[E]);
            }else{
                System.out.println("danger");
            }
        }//while
    }
}