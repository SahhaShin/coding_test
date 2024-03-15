import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String abc = br.readLine();
        StringTokenizer st = new StringTokenizer(abc," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //입력 끝

        System.out.println(BFS(a, b, c));
    }
    public static int BFS(int a, int b, int c){

        if((a+b+c)%3!=0) return 0;

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[1501][1501];

        q.offer(new Node(a, b, c));
        visited[a][b] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.a == cur.b && cur.b == cur.c && cur.b == cur.c){
                return 1;
            }
 
            if(cur.a != cur.b){
                int change_a = cur.a>cur.b? cur.a-cur.b:cur.a+cur.a;
                int change_b = cur.a>cur.b? cur.b+cur.b:cur.b-cur.a;
                
                if(visited[change_a][change_b]) continue;
                q.offer(new Node(change_a, change_b, cur.c));
                visited[change_a][change_b] = true;
            }

            if(cur.a != cur.c){
                int change_a = cur.a>cur.c? cur.a-cur.c:cur.a+cur.a;
                int change_c = cur.a>cur.c? cur.c+cur.c:cur.c-cur.a;

                if(visited[change_a][change_c]) continue;
                q.offer(new Node(change_a, cur.b, change_c));
                visited[change_a][change_c] = true;
            }

            if(cur.b != cur.c){
                int change_b = cur.b>cur.c? cur.b-cur.c:cur.b+cur.b;
                int change_c = cur.b>cur.c? cur.c+cur.c:cur.c-cur.b;

                if(visited[change_b][change_c]) continue;
                q.offer(new Node(cur.a, change_b, change_c));
                visited[change_b][change_c] = true;
            }
        }

        return 0;
    }

    public static class Node{
        int a;
        int b;
        int c;
        public Node(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }    
    }
}