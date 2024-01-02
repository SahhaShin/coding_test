import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NAB = br.readLine();

        StringTokenizer st = new StringTokenizer(NAB," ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String As = br.readLine();
        String Bs = br.readLine();
        st = new StringTokenizer(As," ");
        
        int[] Alist = new int[A];
        for(int a=0;a<A;a++){
            Alist[a]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Alist);

        st = new StringTokenizer(Bs," ");
        int[] Blist = new int[B];
        for(int b=0;b<B;b++){
            Blist[b]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Blist);

        //1. 최대한 2x2 타일로 화장실 타일을 채운다. 남는 부분은 2x1 타일로 채운다.
        int Bcount = N/2;//2
        if(Bcount>B) Bcount = B;
        int Acount = N - (Bcount*2);//1
        
        long result = 0;
        for(int i=1;i<=Acount;i++){
            result += Alist[A-i];
        }

        for(int i=1;i<=Bcount;i++){
            result += Blist[B-i];
        }

        //2. 2x2타일들 중 예쁨 정도가 낮은 타일부터 2x1타일 2개의 예쁨 정도와 비교한다.
        if(Bcount>0){
            int Astart = A-Acount-1;
            for(int i=0;i<Bcount;i++){
                if(Astart<1) break;
                if(Blist[B-Bcount+i]<Alist[Astart]+Alist[Astart-1]){
                    result-=Blist[B-Bcount+i];
                    result+=Alist[Astart];
                    result+=Alist[Astart-1];
                    Astart-=2;
                }
            }
        }
        

        System.out.println(result);
        
    }
}