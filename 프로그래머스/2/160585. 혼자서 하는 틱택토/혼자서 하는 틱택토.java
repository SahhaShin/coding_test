import java.util.*;

class Solution {
    
    static char[][] game;
    
    public int solution(String[] board) {
        
        game = new char[3][3];
        int Ocount = 0;
        int Xcount = 0;
        
        
        //1. 갯수 세기
        for(int i=0;i<3;i++){
            char[] line = board[i].toCharArray();
            for(int j=0;j<3;j++){
                if(line[j]=='O') {
                    Ocount++;
                    game[i][j] = 'O';
                }
                else if(line[j]=='X') {
                    Xcount++;
                    game[i][j] = 'X';
                }
            }
        }
        
        //2. 판단
        if(Xcount>Ocount || Ocount-Xcount>1) return 0;
        if(tictacto('O') && Ocount==Xcount) return 0;
        if(tictacto('X') && Ocount==Xcount+1) return 0;
        
        return 1;
        
    }
    
    //틱택토 검사
    public static boolean tictacto(char target){
        
        //행 검사
        for(int i=0; i<3; i++){
            if(game[i][0] == target &&
               game[i][1] == target &&
               game[i][2] == target
              ) return true;
        }
        
        //열 검사
        for(int i=0; i<3; i++){
            if(game[0][i] == target &&
               game[1][i] == target &&
               game[2][i] == target
             ) return true;
        }
        
        //대각선 검사
        
        //좌우
        if( game[0][0]==target &&
            game[1][1]==target &&
            game[2][2]==target
        ) return true;
        
        //우좌
        if( game[0][2]==target &&
            game[1][1]==target &&
            game[2][0]==target
        ) return true;
        
        return false;
        
    }
}