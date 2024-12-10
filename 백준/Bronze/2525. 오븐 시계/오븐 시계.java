import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        StringTokenizer st = new StringTokenizer(start, " ");
        int takeTime = Integer.parseInt(br.readLine());// 분단위로 들어옴
        // 입력 끝
    
        int hh = Integer.parseInt(st.nextToken());// 시작시간 - 시간
        int mm = Integer.parseInt(st.nextToken());// 시작시간 - 분
    
        // 100/6 = 16...4시간
        // 60분/60 = 1 -> 1시간
        // 61분/60 = 1...1 -> 1시간(몫) 1분(나머지)
        // 23시간+16시간 = 39시간/24 = 1(몫 버림)...15(나머지) -> 15시
    
        // 1. takeTime을 시작시간 분에 더해준다.
        int mmTOhh = (mm + takeTime) / 60;
        int mm_ans = (mm + takeTime) % 60;
    
        // 2. mmTOhh를 시작시간 시간에 더해준다.
        int hh_ans = (hh + mmTOhh) % 24;
    
        System.out.println(hh_ans + " " + mm_ans);
    }
}