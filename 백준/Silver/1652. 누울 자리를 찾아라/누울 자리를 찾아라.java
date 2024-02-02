import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        int row = 0;
        int col = 0;
        for(int i=0; i<N; i++){
            String line = br.readLine();
            int blank = 0;
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == '.'){
                    blank++;
                    if(blank == 2) row++;
                }
                else blank=0;
            }
        }//for end

        //입력 끝

        for(int c=0; c<N; c++){
            int blank = 0;
            for(int r=0; r<N; r++){
                if(map[r][c] == '.'){
                    blank++;
                    if(blank == 2) col++;
                }
                else blank=0;
            }
        }

        System.out.println(row+" "+col);
    }
}