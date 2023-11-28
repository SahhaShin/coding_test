import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people); // 50 50 70 80
        
        int count = 0;
        int E = people.length-1;
        boolean[] sel = new boolean[people.length];
        
        for(int S=0;S<people.length;S++){ //시작점
            
            while(S<E){
                
                count++;
                sel[E] = true;
                E--;
                
                if(people[S]+people[E+1] <= limit){
                    sel[S] = true;
                    break;
                }
            }
            
            if(S==E && !sel[S]){//수렴 완료
                count++;
            }
            
        }// for end
        
       return count;
    }
}