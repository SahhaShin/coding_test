import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static int[][] boomerangType1 = {{0,-1},{1,0}};
    static int[][] boomerangType2 = {{-1,0},{0,-1}};
    static int[][] boomerangType3 = {{-1,0},{0,1}};
    static int[][] boomerangType4 = {{1,0},{0,1}};

    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }

        //입력 끝
        boomerang(0, 0);

        System.out.println(result);
        

    }

    public static void boomerang(int order, int value){//order은 0부터 시작

        if(order == N*M){
            result = Math.max(value, result);
            return;
        }

        //2중 for문을 도는 것과 같다.
        int row = order/M;
        int col = order%M;


        if(!visited[row][col]){

            //부메랑 방향 정하기
            if(inMap(new Direction(row+boomerangType1[0][0], col+boomerangType1[0][1]),new Direction(row+boomerangType1[1][0], col+boomerangType1[1][1]))){ //ㄱ
                //visited 체크
                visited[row][col] = true;
                visited[row+boomerangType1[0][0]][col+boomerangType1[0][1]] = true;
                visited[row+boomerangType1[1][0]][col+boomerangType1[1][1]] = true;
    
                //다음 부메랑 만들러 가기
                boomerang(order+1, value+map[row][col]*2 + map[row+boomerangType1[0][0]][col+boomerangType1[0][1]] + map[row+boomerangType1[1][0]][col+boomerangType1[1][1]]);
    
    
                //visited 체크 해제
                visited[row][col] = false;
                visited[row+boomerangType1[0][0]][col+boomerangType1[0][1]] = false;
                visited[row+boomerangType1[1][0]][col+boomerangType1[1][1]] = false;
            }
    
            if(inMap(new Direction(row+boomerangType2[0][0], col+boomerangType2[0][1]),new Direction(row+boomerangType2[1][0], col+boomerangType2[1][1]))){ //__ㅣ
                //visited 체크
                visited[row][col] = true;
                visited[row+boomerangType2[0][0]][col+boomerangType2[0][1]] = true;
                visited[row+boomerangType2[1][0]][col+boomerangType2[1][1]] = true;
    
                //다음 부메랑 만들러 가기
                boomerang(order+1, value + map[row][col]*2 + map[row+boomerangType2[0][0]][col+boomerangType2[0][1]] + map[row+boomerangType2[1][0]][col+boomerangType2[1][1]]);
    
    
                //visited 체크 해제
                visited[row][col] = false;
                visited[row+boomerangType2[0][0]][col+boomerangType2[0][1]] = false;
                visited[row+boomerangType2[1][0]][col+boomerangType2[1][1]] = false;
            }
    
            if(inMap(new Direction(row+boomerangType3[0][0], col+boomerangType3[0][1]),new Direction(row+boomerangType3[1][0], col+boomerangType3[1][1]))){ //ㄴ
                //visited 체크
                visited[row][col] = true;
                visited[row+boomerangType3[0][0]][col+boomerangType3[0][1]] = true;
                visited[row+boomerangType3[1][0]][col+boomerangType3[1][1]] = true;
    
                //다음 부메랑 만들러 가기
                boomerang(order+1, value + map[row][col]*2 + map[row+boomerangType3[0][0]][col+boomerangType3[0][1]] + map[row+boomerangType3[1][0]][col+boomerangType3[1][1]]);
    
    
                //visited 체크 해제
                visited[row][col] = false;
                visited[row+boomerangType3[0][0]][col+boomerangType3[0][1]] = false;
                visited[row+boomerangType3[1][0]][col+boomerangType3[1][1]] = false;
            }
    
            if(inMap(new Direction(row+boomerangType4[0][0], col+boomerangType4[0][1]),new Direction(row+boomerangType4[1][0], col+boomerangType4[1][1]))){ //|^^
                //visited 체크
                visited[row][col] = true;
                visited[row+boomerangType4[0][0]][col+boomerangType4[0][1]] = true;
                visited[row+boomerangType4[1][0]][col+boomerangType4[1][1]] = true;
    
                //다음 부메랑 만들러 가기
                boomerang(order+1, value + map[row][col]*2 + map[row+boomerangType4[0][0]][col+boomerangType4[0][1]] + map[row+boomerangType4[1][0]][col+boomerangType4[1][1]]);
    
    
                //visited 체크 해제
                visited[row][col] = false;
                visited[row+boomerangType4[0][0]][col+boomerangType4[0][1]] = false;
                visited[row+boomerangType4[1][0]][col+boomerangType4[1][1]] = false;
            }
        }

        boomerang(order+1, value); //여기에 추가로 해주는 이유는 모든 부메랑 방향을 확인하고 나온 후 row==N && col==M 조건을 만족해야 return으로 max를 비교할 수 있기 때문이다.

    }


    public static boolean inMap(Direction d1, Direction d2){

        if(d1.row<0 || d1.row>=N || d1.col<0 || d1.col>=M) return false;
        if(visited[d1.row][d1.col]) return false;

        if(d2.row<0 || d2.row>=N || d2.col<0 || d2.col>=M) return false;
        if(visited[d2.row][d2.col]) return false;

        return true;
    }

    public static class Direction{
        int row;
        int col;

        public Direction(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
}