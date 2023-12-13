import java.util.StringTokenizer;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //1. 오늘 날짜 분리 (년, 월, 일)
        StringTokenizer st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        //2. 종류 분리 (종류, 유효기한)
        HashMap<String, Integer> termList = new HashMap<>();
        for(int i=0;i<terms.length;i++){
            st = new StringTokenizer(terms[i], " ");
            termList.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        //3. 문서 날짜 분리 (년, 월, 일, 종류) -> 본격 결과 도출 프로세스
        int[] result = new int[privacies.length];
        int count = 0;
        
        for(int i=0;i<privacies.length;i++){
            st = new StringTokenizer(privacies[i], ".");
            int docYear = Integer.parseInt(st.nextToken());
            int docMonth = Integer.parseInt(st.nextToken());
            
            String dayType = st.nextToken();
            st = new StringTokenizer(dayType, " ");
            int docDay = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            
            //4. 유효 마지막 날짜 구하기
            int validTerm = termList.get(type);
            
            int validDay = (docDay-1) % 28;
            int changeMonth = 0;
            if(validDay==0) {
                validDay = 28;
                changeMonth++;
            }
            
            int validMonth = (docMonth+validTerm) % 12 - changeMonth;
            int changeYear = (docMonth+validTerm) / 12;
            
            if(validMonth==0){
                validMonth = 12;
                changeYear --;
            }
            
            int validYear = docYear + changeYear;
            
            //5. 4에서 구한 유효날짜 안에 오늘 날짜가 포함되는지 확인
            boolean flag = true;
            if(year<=validYear){
                if(year==validYear && month>validMonth) flag=false;
                
                else if(year==validYear && month<=validMonth){
                    if(month==validMonth && day>validDay) flag=false;
                }
            }else flag=false;
            
            if(!flag) result[count++] = i+1;
            
            System.out.println();
            
        }//for i end
        
        int[] newResult = new int[count];
        for(int i=0;i<count;i++){
            newResult[i] = result[i];
        }
        
        return newResult;
        
    }
}