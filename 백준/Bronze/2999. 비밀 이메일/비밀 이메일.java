import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 편지입력
		char[] letter = sc.next().toCharArray();
		
		//2. 총길이
		int len=letter.length;
		
		//3. R C 탐색
		//R가장 큰 값은 루트(n)이라고 생각함. -> 이건 4 16 이런 숫자만 가능
		int R =0;
		int C=0;
		for(int i=1;i<=Math.sqrt(len);i++) {
			if(len%i==0) {
				R=i;
				C=len/i;
			}
		}
		
		//4. 암호화된 편지 열부터 다시 쓰기
		char[][] secret_letter = new char[R][C];
		int idx=0;
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				secret_letter[j][i]=letter[idx++];
			}
		}
		
		//5. 가로로 출력
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(secret_letter[i][j]);
			}
		}
	}

}
