import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long[] factorial_cal;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int color_count = Integer.parseInt(br.readLine());
        String color_counts = br.readLine(); //5 7
        StringTokenizer st = new StringTokenizer(color_counts," ");

        int color[] = new int[color_count];
        int total_count = 0;
        for(int i=0;i<color_count;i++){
            color[i] = Integer.parseInt(st.nextToken());
            total_count+=color[i];
        }

        int sel_count = Integer.parseInt(br.readLine());

        if(color_count==1 || sel_count==1){
            System.out.println(1.0);
        }else{
            
            double result = 0;
            
            for(int i=0;i<color_count;i++){

                double one_color_possible = 1;
                int sub_total_count = total_count;
                for(int j=0;j<sel_count;j++){
                    one_color_possible*=(double)color[i]/sub_total_count;
                    color[i]--;
                    sub_total_count--;
                }

                result+=one_color_possible;
            }


            //결과 출력
            System.out.println(result);
        }
    }
}