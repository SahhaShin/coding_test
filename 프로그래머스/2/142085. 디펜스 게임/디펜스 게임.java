import java.util.*;

//적을 상대하다가 우리팀이 -가 되었을 때 가장 큰 수의 적을 롤백 == pq
class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ourCount = n;
        int chance = k;
        int result = enemy.length;
        
        //if(enemy.length == k) return enemy.length;
        
        for(int level=0;level<enemy.length;level++){
            pq.offer(enemy[level]);
            ourCount-= enemy[level];
            
            if(ourCount<0){
                if(chance>0 && !pq.isEmpty()){
                    ourCount+= pq.poll();
                    chance--;
                }else{
                    result = level;
                    break;
                }
            }
        }//for end
        
        return result;
    }
}