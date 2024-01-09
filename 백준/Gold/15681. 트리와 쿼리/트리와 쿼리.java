import java.util.*;
import java.io.*;

class Main {
    
    static List<Integer>[] adj;
    static int[] childCount;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {

        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NRQ = br.readLine();
        StringTokenizer st = new StringTokenizer(NRQ, " ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1]; //정점 1부터 시작
        for(int i=0;i<N+1;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1;i<=N-1;i++){
            String UV = br.readLine();
            st = new StringTokenizer(UV, " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            adj[U].add(V);
            adj[V].add(U);
        }

        //2. child 수 세기
        childCount = new int[N+1];
        Arrays.fill(childCount, 1); //자기자신도 포함
        SubTree(R, -1); //-1 : 부모 없음

        //3. 결과
        sb = new StringBuilder();
        for(int T=1;T<=Q;T++){
            int U = Integer.parseInt(br.readLine());
            sb.append(childCount[U]).append("\n");
        }

        System.out.println(sb);
    }

    public static void SubTree(int child, int parent){

        for(int i=0;i<adj[child].size();i++){
            int next = adj[child].get(i);
            if(next == parent) continue;
            SubTree(next, child);
        }

        if(parent!=-1){//부모가 있다면
            childCount[parent] += childCount[child];
        }
    }
}