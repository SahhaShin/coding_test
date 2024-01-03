import java.util.*;
import java.io.*;

class Main {
    
    static List<Integer>[] adj;
    static int N;
    static boolean[] exist; //노드에 팬클럽 곰곰이가 존재하는가?
    static boolean flag = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");

        N = Integer.parseInt(st.nextToken()); //정점
        int M = Integer.parseInt(st.nextToken()); //간선
        
        adj = new ArrayList[N+1]; //정점은 1부터 시작
        for(int i=0;i<N+1;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<M;i++){
            String info = br.readLine();
            st = new StringTokenizer(info, " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
        }
        
        int S = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        st = new StringTokenizer(numbers, " ");
        exist = new boolean[N+1];//정점은 1부터 시작
        for(int i=0;i<S;i++){
            int next = Integer.parseInt(st.nextToken());
            exist[next] = true;
        }

        //입력 끝

        if(!exist[1]) DFS(1);

        if(flag) System.out.println("yes");
        else System.out.println("Yes");

    }

    public static void DFS(int curNode){

        //팬을 만났다면 이 경로는 더 이상 안봐도 됨
        //팬이 없는 경로를 찾았다면 모든 로직을 끝내도 됨
        if(flag || exist[curNode]) return;
        if(adj[curNode].size()==0){
            flag = true;
            return;
        }

        for(int i=0;i<adj[curNode].size();i++){
            int nextNode = adj[curNode].get(i);
            DFS(nextNode);
        }
    }
}