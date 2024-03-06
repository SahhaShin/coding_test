import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String search = br.readLine();

        //투포인터
        int S = 0;
        int E = 0;
        int search_order = 0;

        int count=0;
        while(E<line.length()){
            char cur = line.charAt(E);
            if(cur == search.charAt(search_order)){
                if(search_order == search.length()-1){
                    count++;
                    search_order = 0;
                    S = E+1;
                }else search_order++;
                E++;
            }else{
                S++;
                E = S;
                search_order = 0;
            }
        }
        System.out.println(count);
    }
}