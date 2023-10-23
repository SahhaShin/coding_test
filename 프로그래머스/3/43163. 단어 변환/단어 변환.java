import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    
    public static class Order implements Comparable<Order>{
        String word;
        int order;
        
        public Order(String word, int order){
            this.word = word;
            this.order = order;
        }
        
        @Override
        public int compareTo(Order o){
            return this.order>o.order?1:-1;
        }
    }
    
    static int result = 987654321;
    
    public int solution(String begin, String target, String[] words) {
        
        if(Arrays.asList(words).contains(target)){
            BFS(begin, target, words);   
        }else{
            result=0;
        }
        
        if(result==987654321) result=0;
        
        return result;
    }
    
    public static void BFS(String begin, String target, String[] words){
        Queue<Order> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        //첫 값 넣어주기
        q.offer(new Order(begin,0));
        visited[0] = true;
        
        while(!q.isEmpty()){
            Order cur = q.poll();
            
            if(cur.word.equals(target)){
                result = cur.order;
                return;
            }
            
            //한글자 다른거 찾아서 큐에 넣어주기
            for(int idx=0; idx<words.length; idx++){
                
                int diff = 0; //다른 글자가 1개여야 함
                
                //같은 글자나 이미 들어갔던 글자 비교 금지
                if(words[idx].equals(cur.word)) {
                    continue;
                }
                
                for(int i=0;i<words[idx].length();i++){
                    
                    if(words[idx].charAt(i)!=cur.word.charAt(i)){
                        diff++;
                    }
                }
                
                // System.out.println(cur.word+" "+words[idx]+" "+diff);
                
                if(diff==1){
                      q.offer(new Order(words[idx],cur.order+1));
                }
            }
            
        }
        
        
    }
}