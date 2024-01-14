import java.util.*;
import java.io.*;

class Main {
    static int h;
    static int w;
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] map;
    static boolean[][] visited;
    static HashMap<Character,Integer> key;
    static List<Loc> door;
    static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int T=1;T<=t;T++){
            //System.out.println("start "+" "+T);
            String hw = br.readLine();
            StringTokenizer st = new StringTokenizer(hw, " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            List<Loc> enter = new ArrayList<>();
            key = new HashMap<>();
            door = new ArrayList<>();
            count=0;

            for(int r=0;r<h;r++){
                String line = br.readLine();
                map[r] = line.toCharArray();

                for(int c=0;c<w;c++){
                    //1. 외벽&열쇠&문서 입구 저장, 문이 나왔을 땐 door에 저장
                    if(((r==0 || r==h-1) || ((c==0 || c==w-1))) && map[r][c]=='.') enter.add(new Loc(r,c,map[r][c]));
                    else if(((r==0 || r==h-1) || ((c==0 || c==w-1))) && map[r][c]>='a' && map[r][c]<='z'){
                        enter.add(new Loc(r,c,map[r][c]));
                        key.put(map[r][c],1);
                    }
                    else if(((r==0 || r==h-1) || ((c==0 || c==w-1))) && map[r][c]=='$'){
                        enter.add(new Loc(r,c,map[r][c]));
                    }
                    else if(((r==0 || r==h-1) || ((c==0 || c==w-1))) && map[r][c]>='A' && map[r][c]<='Z'){
                        door.add(new Loc(r,c,map[r][c]));
                    }
                }
            }

            //2. 상근이가 가진 키는 hashMap으로 저장
            String keys = br.readLine();
            if(!keys.equals("0")){
                for(int k=0;k<keys.length();k++){
                    key.put(keys.charAt(k),1);
                }
            }

            //door에 뭐가 있고, 그에 맞는 열쇠가 있다면 enter에 넣기
            for(int i=0;i<door.size();i++){
                Loc loc = door.get(i);
                if(key.get((char)(loc.word+32))!=null) enter.add(new Loc(loc.r,loc.c,map[loc.r][loc.c]));
            }

            //3. 외벽에 자리가 없으면 0 출력 후 끝
            if(enter.size()==0) sb.append("0").append("\n");
            else{
                //4. 입구 수만큼 BFS(visited 체크) 돌려주기
                visited = new boolean[h][w];
                for(int in=0;in<enter.size();in++){
                    Loc loc = enter.get(in);
                    if(visited[loc.r][loc.c]) continue;
                    //System.out.println("enter");
                    BFS(loc);
                }//in

                sb.append(count).append("\n");
            }
            
        }//test case

        System.out.println(sb);
        
    }

    public static void BFS(Loc start){
        Queue<Loc> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c] = true;

        while(!q.isEmpty()){
            Loc cur = q.poll();
            //System.out.println(cur.r+" "+cur.c+" "+map[cur.r][cur.c]);
            if(map[cur.r][cur.c]=='$'){//문서 발견
                count++;
            }
            
            for(int d=0;d<4;d++){
                int nextR = cur.r+drc[d][0];
                int nextC = cur.c+drc[d][1];

                if(nextR<0 || nextR>=h || nextC<0 || nextC>=w) continue;
                if(visited[nextR][nextC]) continue;
                
                
                if(map[nextR][nextC]=='.' || map[nextR][nextC]=='$'){
                    q.offer(new Loc(nextR, nextC,map[nextR][nextC]));
                    visited[nextR][nextC]=true;
                }
                else if(map[nextR][nextC]>='A' && map[nextR][nextC]<='Z'){
                    if(key.get((char)(map[nextR][nextC]+32))!=null){//키가 있음 갈 수 있음
                        q.offer(new Loc(nextR, nextC,map[nextR][nextC]));
                        visited[nextR][nextC]=true;
                    }else{
                        // 돌다가 방이 나왔는데 키가 없다.
                        // '여기 갈 수 있었는데 못갔어' 느낌으로 door HashMap에 넣기 -> 키를 얻으면 이 HashMap 조사
                        door.add(new Loc(nextR,nextC,map[nextR][nextC]));
                    }
                }
                else if(map[nextR][nextC]>='a' && map[nextR][nextC]<='z'){
                    //열쇠가 나오면 열쇠hashMap에 저장
                    q.offer(new Loc(nextR, nextC,map[nextR][nextC]));
                    visited[nextR][nextC]=true;
                    key.put(map[nextR][nextC],1);

                    // 키에 대한 door 정보가 HashMap에 있으면 그 위치를 큐에 넣어주기
                    for(Loc info : door){
                        if(info.word == map[nextR][nextC]-32){ //map[nextR][nextC]-32 == key
                            if(visited[info.r][info.c]) continue;
                            q.offer(new Loc(info.r, info.c,map[info.r][info.c]));
                            visited[info.r][info.c] = true;
                        }
                    }
                }
                
            }
        }//while
    }

    public static class Loc{
        int r;
        int c;
        char word;
        public Loc(int r, int c, char word){
            this.r=r;
            this.c=c;
            this.word=word;
        }
    }
}