class Solution {

    public int solution(String s) {
        
        int answer = s.length();
        int count = 1; //같은 문자열 수
        
        for(int i=1;i<=s.length()/2;i++){
            StringBuilder result = new StringBuilder();
            String origin = s.substring(0,i);
            
            //j는 문자 자르기 시작점
            for(int j=i;j<=s.length();j+=i){
                //어디까지 자를 것인지 i+j가 s.length()을 넘으면 안됨
                int endIdx = Math.min(j+i, s.length());
                String compare = s.substring(j, endIdx);
                
                if(origin.equals(compare)){
                    count++;
                }else{ //같지 않아
                    if(count>=2){
                        result.append(count);
                    }
                    //길이가 1이어도 무조건 그냥 넣어주니까
                    result.append(origin);
                    
                    //origin을 현재 다른 compare로 바꿔서 비교 또 시작
                    origin = compare;
                    count = 1;//초기화
                }
            }
            //마지막 문자열 비교할 때 같다면 count만 증가시키고 나올 것이다.
            //달라도 origin에 compare 넣어주니까 한 번 더 넣어준다.
            //문자열 길이 중간 완성
            result.append(origin);
            answer = Math.min(answer, result.length());
        }//end
        
        return answer;
    }
}