import java.util.HashMap;
class Solution {
    //다양한 종류의 포켓몬을 가질 수 있어야 한다.
    
    public int solution(int[] nums) {
        int answer = 0;
        
        int canGet = nums.length/2;//n/2만큼 포켓몬을 가질 수 있음
        
        HashMap<Integer, Integer> realMoster = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //중복이 있어도 그냥 넣는다.
            realMoster.put(nums[i], nums[i]);
        }
        
        if(realMoster.size()>canGet) answer = canGet;
        else answer = realMoster.size();

        
        return answer;
    }
}