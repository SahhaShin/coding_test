import java.util.Scanner;
import java.util.List;
import  java.util.ArrayList;

public class Main { // 제한시간 2초

    static int N;
    static char[][] map;

    static List<Node> xList = new ArrayList<>();//빈공간 모아둔 곳
    static List<Node> teacherList = new ArrayList<>();//선생님들 좌표를 모아둔 곳

    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};//상하좌우

    static Node[] sel = new Node[3];//장애물은 고정 3개

    static String result = "NO";

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //변수 선언
        map = new char[N][N];


        //1. X위치 저장, 선생님 위치 저장
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.next().charAt(0);
                
                //빈공간 위치
                if(map[i][j] == 'X'){
                    xList.add(new Node(i, j));
                }

                //선생님 위치 저장
                else if(map[i][j] == 'T'){
                    teacherList.add(new Node(i, j));
                }
            }
        }


        //2. 빈공간 중 고정 3개 조합 꾸리기 -> Combination함수
        Combination(0, 0);

        System.out.println(result);
        
    }


    //3개 조합
    public static void Combination(int depth, int idx){

        if(depth==3){

            //새로운 copyMap 생성 -> 1차원만 가능
            char[][] copyMap = new char[N][N];
            for(int i=0;i<N;i++) copyMap[i] = map[i].clone();

            //3개조합 copyMap에 'O'표시
            for(int i=0;i<3;i++){
                copyMap[sel[i].x][sel[i].y]='O';
            }

            
            if(Check(copyMap)){// 가능한 조합인가?
                result = "YES";
            }

            return;
        }

        if(idx==xList.size()) return;

        sel[depth]=xList.get(idx);
        Combination(depth+1, idx+1);//선택

        Combination(depth, idx+1);//미선택

    }

    //학생들은 선생님에게 모두 걸리지 않을 수 있을까?
    public static boolean Check(char[][] copyMap){

        for(int i=0;i<teacherList.size();i++){

            Node curTeacher = teacherList.get(i);

            //4방탐색
            for(int d=0;d<4;d++){
                int nextR = curTeacher.x;
                int nextC = curTeacher.y;

                while (true) {
                    nextR += drc[d][0];
                    nextC += drc[d][1];

                    //경계체크
                    if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) break;
                    
                    //장애물 체크
                    if(copyMap[nextR][nextC]=='O') break;
                    
                    //학생체크
                    if(copyMap[nextR][nextC]=='S') return false;

                    copyMap[nextR][nextC] = 'w';
                    
                }
            }
        }

        return true;

    }


    static public class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    
}