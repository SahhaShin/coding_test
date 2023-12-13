import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String E = sc.next();
        String Q = sc.next();
        
        //1. 시작 시간 분리
        StringTokenizer st = new StringTokenizer(S,":");
        int Shh = Integer.parseInt(st.nextToken());
        int Smm = Integer.parseInt(st.nextToken());

        //2. 끝나는 시간 분리
        st = new StringTokenizer(E,":");
        int Ehh = Integer.parseInt(st.nextToken());
        int Emm = Integer.parseInt(st.nextToken());

        //3. 방송 종료 시간 분리
        st = new StringTokenizer(Q,":");
        int Qhh = Integer.parseInt(st.nextToken());
        int Qmm = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> attendList = new HashMap<>();
        int count = 0;

        while(sc.hasNext()){
            String time = sc.next();
            String name = sc.next();

            st = new StringTokenizer(time,":");
            int hh = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());

            //4. 방송 종료 체크
            if(hh>Qhh) break;
            if(hh==Qhh && mm>Qmm) break;

            //5. 입실 체크 (1)
            if(hh<=Shh){
                if(hh==Shh && mm>Smm) continue;
                if(hh>Shh) continue;

                attendList.put(name, 1);
            }

            //6. 퇴실 체크 (2)
            if(hh>=Ehh && hh<=Qhh){
                if(hh==Ehh && mm<Emm) continue;
                if(hh==Qhh && mm>Qmm) continue;

                if(attendList.get(name)!=null && attendList.get(name)==1){
                    count++;
                    attendList.put(name,2);
                }
            }

        }//while

        System.out.println(count);
        
    }
}