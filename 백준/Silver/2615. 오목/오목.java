import java.util.*;
import java.io.*;

//1) 가장 왼쪽에 있는 돌 2)가장 위에 있는 돌
class Main {
    //아래만 검사하면 딱 5개인지는 알 수 없는데 -> 위에 돌이 있었는데 안 멈춘 경우 -> x
    static int[][] drc = {{0,1},{1,0},{1,1},{1,-1}}; //우, 하, 우하,좌하 대각선
    static int[][] drc_check = {{0,-1},{-1,0},{-1,-1},{-1,1}}; //좌, 상, 좌상, 우상
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[20][20];
        for(int r=1;r<=19;r++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            for(int c=1;c<=19;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //입력 끝

        start:for(int r=1;r<=19;r++){
            for(int c=1;c<=19;c++){
                if(map[r][c]!=0){//바둑알O
                    int result = check(r, c, map[r][c]);
                    if(result!=-1){//빙고
                        if(result==3){
                            System.out.println(map[r+drc[3][0]*4][c+drc[3][1]*4]);
                            System.out.println((r+drc[3][0]*4)+" "+(c+drc[3][1]*4));
                        }else{
                            System.out.println(map[r][c]);
                            System.out.println(r+" "+c);
                        }
                        return;
                    }
                }
            }
        }

        System.out.println(0);
        
    }

    public static int check(int r, int c, int num){

        //우(rc), 하(rc), 우하(rc),좌하(끝이 정답) 대각선
        for(int d=0;d<4;d++){
            int checkR = r+drc_check[d][0];
            int checkC = c+drc_check[d][1];
            
            if(checkR<0 || checkR>19 || checkC<0 || checkC>19) continue;
            if(map[checkR][checkC]==num) continue;

            int count = 1; //map[r][c]
            int nextR = r;
            int nextC = c;
            while(map[nextR][nextC] == num){
                nextR = r+drc[d][0]*count;
                nextC = c+drc[d][1]*count;

                if(nextR<0 || nextR>19 || nextC<0 || nextC>19) break;
                if(map[nextR][nextC]==num) count++;
            }

            if(count == 5) return d;
        }

        return -1;
    }
}