class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int bell1 = ringABell(h1, m1, s1);
        int bell2 = ringABell(h2, m2, s2);
        
        //bell2 - bell1을 해주되 시작하는 시간이 빠지면 안되니 고려한다.
        int result = bell2-bell1;
        if((h1==12 || h1==0)&&m1==0&&s1==0) result++;
        
        return result;
        
    }
    
    public static int ringABell(int h, int m, int s){
        
        //1. 00:00:00은 1번만 종이 울림
        int bell=-1;
        
        //2. 0초에서 시작해서 -> s초로 가기까지 시침과 분침을 마주쳤는지 확인
        double hDeg = (h*30+m*0.5+s*0.5/60)%360;
        double mDeg = (m*6+s*0.1)%360;
        double sDeg = s*6%360;
        
        if(sDeg>=hDeg) bell++;
        if(sDeg>=mDeg) bell++;
        
        //3. 잉여 초 고려 완료 -> 1분마다 초침은 시침/분침(*2) 만난다.
        bell += (m+h*60)*2;
        
        //4. 24시간 중 1분씩은 초침이 분침을 만나지 않는다.
        bell-=h;
        
        //5. 11:59 -> 12:00 시침은 초침과 만나지 않는다. + 12:00:00은 1번만 벨이 울린다.
        if(h>=12) bell-=2;
        
        return bell;
    }
}