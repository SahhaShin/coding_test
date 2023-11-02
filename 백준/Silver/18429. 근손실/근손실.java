import java.util.Scanner;

public class Main {

    static int N;
    static int K;
    static int[] kit;
    static int[] sel;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 일수
        K = sc.nextInt(); //근손실
        kit = new int[N];
        for(int i=0; i<N; i++){
            kit[i] = sc.nextInt();
        }

        sel = new int[N];
        visited = new boolean[N];

        Permutation(0);

        System.out.println(result);
    }

    //per
    public static void Permutation(int depth){
        
        if(depth == N){
            if(Check()){
                result++;
            }

            return;
        }

        for(int i=0;i<N;i++){

            if(visited[i]) continue;

            visited[i] = true;
            sel[depth] = kit[i];
            Permutation(depth+1);

            visited[i] = false;

        }

    }

    public static boolean Check(){
        //500이하로 떨어지면 바로 false
        int start = 500;

        for(int i=0;i<N;i++){
            start += sel[i];
            start -= K;
            if(start < 500) return false;
        }

        return true;
    }
}