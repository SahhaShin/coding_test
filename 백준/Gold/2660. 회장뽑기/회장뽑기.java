import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<Integer>[] friend;
    static List<Order> order = new ArrayList<>(); //계산된 점수
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        friend = new ArrayList[N+1];//1번부터 시작
        for(int i=0;i<=N;i++){
            friend[i] = new ArrayList<>();
        }
        
        while(true){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            if(f1==-1 && f2==-1) break;

            friend[f1].add(f2);
            friend[f2].add(f1);
        }

        //입력 끝

        for(int p=1;p<=N;p++){
            Closer(p);
        }

        Collections.sort(order, (o1, o2) -> {
            if(o1.order == o2.order) return o1.num>o2.num?1:-1;
            else return o1.order>o2.order?1:-1;
        });
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int min = order.get(0).order;
        
        for(int p=0;p<N;p++){
            Order next = order.get(p);
            if(next.order == min){
                sb.append(next.num).append(" ");
                count++;
            }
        }

        System.out.println(min+" "+count);
        System.out.println(sb);
        
    }

    public static void Closer(int p){
        Queue<Order> list = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int link = 1;

        list.offer(new Order(p, 0));
        visited[p] = true;

        while(!list.isEmpty()){
            Order cur = list.poll();
            if(cur.order > link) link = cur.order;

            for(int i=0;i<friend[cur.num].size();i++){
                int next = friend[cur.num].get(i);
                if(visited[next]) continue;

                visited[next] = true;
                list.offer(new Order(next, cur.order+1));
            }
        }// while

        order.add(new Order(p, link));
    }
    

    public static class Order{
        int num;
        int order;
        public Order(int num, int order){
            this.num = num;
            this.order = order;
        }
    }
}