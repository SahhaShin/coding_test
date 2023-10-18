import java.util.HashMap;
import java.util.Map;
class Solution {
    //미완주자 명단
    //단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
    //동명이인은 서로 다른 사람이다.
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> status = new HashMap<>();
    
        //참가자 상태 저장
        //containsKey 사용도 가능
        for(int i=0;i<participant.length;i++){
            status.put(participant[i],status.getOrDefault(participant[i],0)+1);
        }
        
        //완주자 상태 저장
        //replace도 사용가능
        for(int i=0;i<completion.length;i++){
            status.put(completion[i],status.get(completion[i])-1);
        }
        
        //1명이라도 남아있는 사람이 정답
        for(Map.Entry<String, Integer> set : status.entrySet()){
            if(set.getValue()==1){
                answer = set.getKey();
                break;
            }
        }
        
        
        return answer;
    }
}