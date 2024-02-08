import java.util.*;
import java.io.*;

//k개의 부등호 순서를 만족하는 (k+1)자리의 정수 중에서 최댓값과 최솟값을 찾아야 한다.
//선택된 숫자는 모두 달라야 한다.
// 첫 자리가 0인 경우도 정수에 포함되어야 한다.
class Main {
    
    static int N;
    static int[] sel;
    static boolean[] number;
    static String[] sign;
    static long max = 0;
    static String maxString;
    static long min = Long.MAX_VALUE;
    static String minString;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String signs = br.readLine();
        StringTokenizer st = new StringTokenizer(signs," ");
        
        sign = new String[N];
        for(int i=0; i<N; i++){
            sign[i] = st.nextToken();
        }

        //입력 끝

        sel = new int[N+1];
        number = new boolean[10];

        Permutation(0);

        System.out.println(maxString);
        System.out.println(minString);
    }
    
    public static void Permutation(int depth){
        if(depth==N+1){
            if(Complete()){
                
                String s = "";
                for(int i=0; i<N+1; i++) s+=sel[i];

                //System.out.println(s);
                
                if(Long.parseLong(s)>max){
                    max = Long.parseLong(s);
                    maxString = s;
                }
                if(Long.parseLong(s)<min){
                    min = Long.parseLong(s);
                    minString = s;
                }
            }
            return;
        }

        for(int i=0; i<=9; i++){
            if(number[i]) continue;
            number[i] = true;
            
            sel[depth] = i;
            Permutation(depth+1); //선택

            number[i] = false;
        }
    }

    public static boolean Complete(){

        for(int i=0; i<N; i++){
            if(sign[i].equals(">")){
                if(sel[i] <= sel[i+1]) return false;
            }else if(sign[i].equals("<")){
                if(sel[i] >= sel[i+1]) return false;
            }
        }

        return true;
        
    }
}