import java.util.*;
import java.io.*;

class Main {

    static Character[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                                     {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                                     {'z', 'x', 'c', 'v', 'b', 'n', 'm'}};
    
    static HashMap<Character, Loc> location = new HashMap<Character, Loc>(){{
        put('q', new Loc(0,0)); put('w', new Loc(0,1)); put('e', new Loc(0,2)); put('r', new Loc(0,3));
        put('t', new Loc(0,4)); put('y', new Loc(0,5)); put('u', new Loc(0,6)); put('i', new Loc(0,7));
        put('o', new Loc(0,8)); put('p', new Loc(0,9));
        
        put('a', new Loc(1,0)); put('s', new Loc(1,1)); put('d', new Loc(1,2)); put('f', new Loc(1,3));
        put('g', new Loc(1,4)); put('h', new Loc(1,5)); put('j', new Loc(1,6)); put('k', new Loc(1,7));
        put('l', new Loc(1,8));

        put('z', new Loc(2,0)); put('x', new Loc(2,1)); put('c', new Loc(2,2)); put('v', new Loc(2,3));
        put('b', new Loc(2,4)); put('n', new Loc(2,5)); put('m', new Loc(2,6));
    }};
    
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static String userInput;
    static Distance[] word;
    static int wordCount;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int T=1; T<=t; T++){
            String info = br.readLine();
            StringTokenizer st = new StringTokenizer(info," ");
            
            userInput = st.nextToken();
            wordCount = Integer.parseInt(st.nextToken());

            word = new Distance[wordCount];
            for(int i=0; i<wordCount; i++){
                String target = br.readLine();
                word[i] = new Distance(target, Calculation(userInput, target));
            }

            Arrays.sort(word, new Comparator<Distance>(){
                @Override
                public int compare(Distance o1, Distance o2){
                    if(o1.dis==o2.dis){
                        for(int i=0; i<o1.word.length(); i++){
                            Character word1 = o1.word.charAt(i);
                            Character word2 = o2.word.charAt(i);
                            
                            if(word1 == word2) continue;
                            
                            return word1>word2?1:-1;
                        }
                    }
                    return o1.dis>o2.dis?1:-1;
                }
            });
            
            for(int i=0; i<wordCount; i++){
                sb.append(word[i]. word).append(" ").append(word[i].dis).append("\n");
            }
            
        }//test case

        System.out.println(sb);
    }

    //char2 == 컴퓨터에 있는 단어
    //char1 == userInput
    public static int Calculation(String str1, String str2){//단어 간의 거리 계산

        int len = 0;
        
        for(int i=0; i<str1.length(); i++){
            Character char1 = str1.charAt(i);
            Character char2 = str2.charAt(i);
            
            if(char1 == char2) continue;
            
            Loc userInput = location.get(char1);
            Loc computer = location.get(char2);
            len += Math.abs(computer.r - userInput.r) + Math.abs(computer.c - userInput.c);
        }

        return len;
    }

    public static class Distance{
        String word;
        int dis;
        public Distance(String word, int dis){
            this.word = word;
            this.dis = dis;
        }
    }

    public static class Loc{
        int r;
        int c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}