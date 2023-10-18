import java.util.Arrays;
class Solution {
    //1. phone_book을 sort한다.
    //2. 뒤 인덱스만 보면 된다. (나랑 가장 가까운 숫자가 내 뒤에 있는 거니까)
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        //1
        for(int i=0;i<phone_book.length-1;i++){
            int st_size = phone_book[i].length();
            
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return answer;
    }
}