import java.util.*;
import java.io.*;

class Main {
    static PriorityQueue<Lecture> list = new PriorityQueue<>();;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String se = br.readLine();
            StringTokenizer st = new StringTokenizer(se," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.offer(new Lecture(start, end));
        }

        //입력 끝
        
        //방 배정
        // 방이 만들어지면 관리해야함
        System.out.println(RoomManage());
        
    }

    public static int RoomManage(){
        PriorityQueue<Integer> room = new PriorityQueue<>();
        Lecture firstRoom = list.poll();
        room.offer(firstRoom.end);

        while(!list.isEmpty()){
            Lecture lec = list.poll();
            int roomEndTime = room.peek();

            if(lec.start>=roomEndTime){
                room.poll();
            }
            
            room.offer(lec.end);
        }

        return room.size();
    }

    public static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o){
            if(this.start == o.start){
                if(this.end>=o.end) return 1;
                else return -1;
            }
            return this.start>=o.start?1:-1;
        }
    }
}