//시작시간 : 오전 12시 28분
import java.util.*;

public class Solution {
    //연속 수 제거
    //1. 스택에 arr를 순차적으로 넣는다.
    //2. 넣기 전 스택 가장 위에 있는 요소와 같은지 확인한다. -> 같으면 넣지 않는다.
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }
            else{
                if(stack.peek()==arr[i]) continue;
                else stack.push(arr[i]);
            }
        }
        
        int[] answer = new int[stack.size()];

        for(int i=stack.size()-1;i>=0;i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}