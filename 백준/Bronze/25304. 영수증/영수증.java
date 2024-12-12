import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long total = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long cal_total = 0;
        
        for (int i=0; i<N; i++){
            String priceAndCount = br.readLine();
            StringTokenizer st = new StringTokenizer(priceAndCount, " ");
            cal_total += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        }

        if(total == cal_total){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}