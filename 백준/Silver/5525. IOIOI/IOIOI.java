import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();

        char target = 'I';
        int count = 0;
        int result = 0;
        for(int i=0; i<M; i++){
            if(line.charAt(i)==target){
                count++;
                if(target=='I') target='O';
                else if(target=='O') target='I';

                if(count==N+N+1){
                    result++;
                    count-=2;
                } 
            }else{
                if(line.charAt(i)=='I'){
                    target = 'O';
                    count = 1;
                }else{
                    target = 'I';
                    count = 0;
                }
            }
        }

        System.out.println(result);
    }
}