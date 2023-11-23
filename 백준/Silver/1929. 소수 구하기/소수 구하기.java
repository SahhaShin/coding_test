import java.util.Scanner;

public class Main
{

    static int minNum;
    static int maxNum;
    static boolean[] matrix;

    //(1 ≤ M ≤ N ≤ 1,000,000)
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        minNum = sc.nextInt();
        maxNum = sc.nextInt();

        matrix = new boolean[maxNum+1]; 

        eratos();

        for(int i=minNum;i<=maxNum;i++){
            if(!matrix[i]) System.out.println(i);
        }

    }

    public static void eratos(){
        matrix[1] = true;
        for(int i=2;i<=maxNum;i++){
            for(int j=2*i; j<=maxNum; j+=i){
                matrix[j] = true;
            }
        }
    }
}