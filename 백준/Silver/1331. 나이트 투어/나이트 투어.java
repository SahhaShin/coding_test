import java.io.*;

class Main {

    static int[][] map;
    static int[][] drc = {{2,-1},{2,1},{-2,-1},{-2,1},{1,-2},{-1,-2},{1,2},{-1,2}};
    static String result = "Valid";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new int[6][6];
        int[][] firstLocation = new int[1][2];
        
        for(int i=1;i<=36;i++){
            String cmd = br.readLine();
            int row = cmd.charAt(1)-'0'-1;
            int col = cmd.charAt(0)-'A';

            if(map[row][col]!=0){
                result = "Invalid";
                break;
            }
            map[row][col] = i;

            //1번 위치 저장
            if(i==1){
                firstLocation[0][0] = row;
                firstLocation[0][1] = col;
            }
        }

        if(result.equals("Valid")){
            move(firstLocation[0][0], firstLocation[0][1], 1);
        }

        System.out.println(result);
        
    }

    public static void move(int row, int col, int num){

        for(int d=0;d<8;d++){
            int nextR = row+drc[d][0];
            int nextC = col+drc[d][1];

            if(nextR<0 || nextR>=6 || nextC<0 || nextC>=6) continue;

            if(num==36 && map[nextR][nextC]==1) return;
            

            else if(map[nextR][nextC]==num+1) {
                move(nextR, nextC, num+1);
                return;
            }
        }

        result = "Invalid";
        
    }
}