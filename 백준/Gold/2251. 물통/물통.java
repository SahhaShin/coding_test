import java.util.*;
import java.io.*;

class Main {
    static int maxA, maxB, maxC;
    static List<Integer> cList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ABC = br.readLine();
        StringTokenizer st = new StringTokenizer(ABC," ");

        maxA = Integer.parseInt(st.nextToken());
        maxB = Integer.parseInt(st.nextToken());
        maxC = Integer.parseInt(st.nextToken());

        PourBFS();

        Collections.sort(cList);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cList.size();i++){
            sb.append(cList.get(i)).append(" ");
        }

        System.out.println(sb);
        
    }

    public static void PourBFS(){
        Queue<Bottle> q = new LinkedList<>();
        boolean[][][] visited = new boolean[maxA+1][maxB+1][maxC+1];

        q.offer(new Bottle(0,0,maxC));

        while(!q.isEmpty()){
            Bottle cur = q.poll();
            
            //나왔던 케이스는 패스
            if(visited[cur.a][cur.b][cur.c]) continue;
            visited[cur.a][cur.b][cur.c] = true;

            //A = 0 이면 대상
            if(cur.a == 0) cList.add(cur.c);

            //지금 나온 보틀 케이스에서 할 수 있는 모든 상황을 다 해
            //A->B
            if(cur.a+cur.b>maxB){
                q.offer(new Bottle(cur.a+cur.b-maxB,maxB,cur.c));
            }else{
                q.offer(new Bottle(0,cur.a+cur.b,cur.c));
            }

            //A->C
            if(cur.a+cur.c>maxC){
                q.offer(new Bottle(cur.a+cur.c-maxC,cur.b,maxC));
            }else{
                q.offer(new Bottle(0,cur.b,cur.a+cur.c));
            }

            //B->C
            if(cur.b+cur.c>maxC){
                q.offer(new Bottle(cur.a,cur.b+cur.c-maxC,maxC));
            }else{
                q.offer(new Bottle(cur.a,0,cur.b+cur.c));
            }

            //C->B
            if(cur.b+cur.c>maxB){
                q.offer(new Bottle(cur.a,maxB,cur.b+cur.c-maxB));
            }else{
                q.offer(new Bottle(cur.a,cur.b+cur.c,0));
            }
            
            //C->A
            if(cur.a+cur.c>maxA){
                q.offer(new Bottle(maxA,cur.b,cur.a+cur.c-maxA));
            }else{
                q.offer(new Bottle(cur.a+cur.c,cur.b,0));
            }
            
            //B->A
            if(cur.a+cur.b>maxA){
                q.offer(new Bottle(maxA,cur.a+cur.b-maxA,cur.c));
            }else{
                q.offer(new Bottle(cur.a+cur.b,0,cur.c));
            }
        }
    }

    public static class Bottle{
        int a;
        int b;
        int c;
        public Bottle(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}