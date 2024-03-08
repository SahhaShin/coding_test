class Solution {
    
    int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        
        int[][] score = new int[row][col];
        score[0][0] = land[0][0];
        score[0][1] = land[0][1];
        score[0][2] = land[0][2];
        score[0][3] = land[0][3];
        
        for(int i=1; i<row; i++){
            for(int j=0; j<col; j++){
                for(int d=0; d<4; d++){
                    if(j==d) continue;
                    score[i][j] = Math.max(score[i][j], land[i][j]+score[i-1][d]);
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<4; i++){
            max = Math.max(max, score[row-1][i]);
        }
        
        return max;
    }
}