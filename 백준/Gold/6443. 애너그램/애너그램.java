import java.util.*;

//중복 없는 순열 문제 + aa와 같은 중복 요소 건너 뛰기 = next permutation

class Main {

    static char[] word;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int T=1;T<=t;T++){
            word = sc.next().toCharArray();
            Arrays.sort(word);
            
            do{
                System.out.println(word);
            }while(NextPermutation());
        }
        
    }

    public static boolean NextPermutation(){
        int idx_a = word.length-1;
        while(idx_a>0 && word[idx_a-1]>=word[idx_a])idx_a--;
        if(idx_a==0) return false;

        int idx_b = word.length-1;
        while(word[idx_a-1]>=word[idx_b])idx_b--;
        Swap(idx_a-1, idx_b);

        int idx_k = word.length-1;
        while(idx_a<idx_k) Swap(idx_a++, idx_k--);
        
        return true;
    }

    public static void Swap(int idx_a, int idx_b){
        char term = word[idx_a];
        word[idx_a] = word[idx_b];
        word[idx_b] = term;
    }
}