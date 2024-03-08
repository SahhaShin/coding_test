import java.util.*;
import java.io.*;

class Main {
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};//상하좌우
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String info = br.readLine();

        //1. 지도 크기 구하기
        int curR = 0;
        int curC = 0;
        int minR = 0;
        int maxR = 0;
        int minC = 0;
        int maxC = 0;
        int direc = 1;//하
        for(int i=0; i<N; i++){
            char curPosition = info.charAt(i);
            if(curPosition=='F'){//전진
                curR = curR + drc[direc][0];
                curC = curC + drc[direc][1];
                minR = Math.min(minR, curR);
                maxR = Math.max(maxR, curR);
                minC = Math.min(minC, curC);
                maxC = Math.max(maxC, curC);
            }else{//방향전환
                direc = ChangeDirec(curPosition, direc);
            }
        } //end for
        

        //2. 점찍기
        int row = maxR - minR + 1;
        int col = maxC - minC + 1;
        int startR = Math.abs(minR);
        int startC = Math.abs(minC);

        char[][] map = new char[row][col];
        for(int i=0; i<row; i++){
            Arrays.fill(map[i], '#');
        }        
        map[startR][startC] = '.';

        direc = 1;//하
        for(int i=0; i<N; i++){
            char curPosition = info.charAt(i);
            if(curPosition=='F'){//전진
                startR = startR + drc[direc][0];
                startC = startC + drc[direc][1];
                map[startR][startC] = '.';
            }else{//방향전환
                direc = ChangeDirec(curPosition, direc);
            }
        }

        //3. 출력
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        
    }

    public static int ChangeDirec(char curPosition, int direc){
        if(curPosition=='L'){
            if(direc == 0) direc = 2; //상 -> 좌
            else if(direc == 1) direc = 3; //하 -> 우
            else if(direc == 2) direc = 1; //좌 -> 하
            else direc = 0; //우 -> 상
        }else{//'R'
            if(direc == 0) direc = 3; //상 -> 우
            else if(direc == 1) direc = 2; //하 -> 좌
            else if(direc == 2) direc = 0; //좌 -> 상
            else direc = 1; //우 -> 하
        }

        return direc;
    }
}

//row : 3
//col : -3

//min row : 0
//max row : 6

//min col : -6
//max col : 0

//입력 받으면서 위 과정 진행
//row, col구하면 map 생성
//#으로 fill
//방향 이동하면서 F위치로 이동하며 . 업데이트