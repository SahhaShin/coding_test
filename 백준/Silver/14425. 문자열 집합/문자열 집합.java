import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String,Integer> S = new HashMap<>();
        
        for(int i=0;i<N;i++){
            String word = sc.next();
            S.put(word, 0);
        }

        int result = 0;
        for(int i=0;i<M;i++){
            String word = sc.next();

            if(S.get(word)!=null) result++;
        }
        System.out.println(result);
    }
}