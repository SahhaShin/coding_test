import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cm = new int[10]; //1~9번 난쟁이 
		int total = 0; //난쟁이 전체 키 
		for(int i=1;i<=9;i++) {
			cm[i]=sc.nextInt();
			total+=cm[i];
		}
		
		//sort
		Arrays.sort(cm);
		
		//2명 잡아서 전체 키에서 뺐을 때 100이면 난쟁이 확정 
		int one=0;//난쟁이 1명 인덱스 저장 
		int two=0;//난쟁이 1명 인덱스 저장 
		go : for(int i=1;i<=9;i++) {
			for(int j=i+1;j<=9;j++) {
				if(total-(cm[i]+cm[j])==100) {
					one=i;
					two=j;
					break go;
				}
			}
		}
		//오름차 순으로 난쟁이 순서 출력 
		for(int i=1;i<=9;i++) {
			if(i==one || i ==two) {
				continue;
			}
			else {
				System.out.println(cm[i]);
			}
		}
	}

}
