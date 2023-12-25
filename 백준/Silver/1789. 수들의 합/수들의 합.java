import java.util.*;

//1~ 쭉 더해주다가 S보다 큰 수를 더했을 때를 찾아 -1 해주면 된다.
class Main {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();

        long sum = 0;
        int i = 1;
        while(sum<=S){
            sum+=i++;
        }
       System.out.println(i-2);   
    }
}