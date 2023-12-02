//bandage = [기술 시전 시간, 1초당 회복량, 추가 회복량]
//health = 최대 체력
//attacks = [[공격시간, 피해량]]
//return = 남은 체력, 죽으면 -1

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        //1. 마지막 공격 시간을 알아야 한다.
        int lastTime = attacks.length-1;
        int lastAttackTime = attacks[lastTime][0];
        
        
        //2. 회복과 공격 추이
        int attackCount = 0;//몇 번째 공격 인덱스와 time을 비교할 건지
        int continueBandCount = 0;//연속 기술 시전 횟수
        
        for(int time=1;time<=lastAttackTime;time++){
            
            //공격 들어오면 회복 못함 때문에 공격이 있는지 확인
            if(time == attacks[attackCount][0]){ //공격 있음
                answer -= attacks[attackCount][1]; //체력 감소
                attackCount++;
                
                continueBandCount = 0;
                
                //공격을 당한 후 체력이 0인지 확인
                if(answer<=0) return -1;
            
            }else{ //공격 없음
                
                //1초당 체력 회복 > 체력회복은 max를 못 넘음
                if(answer < health){
                    answer += bandage[1];
                    continueBandCount++;
                    
                    if(continueBandCount == bandage[0]){ //연속 회복 성공
                        answer += bandage[2];
                        continueBandCount = 0;
                    }
                    
                    if(answer>health) answer = health;
                } 
            }
            //System.out.println("time = "+time+" "+"life = "+answer);
        }
        
        return answer;
    }
}