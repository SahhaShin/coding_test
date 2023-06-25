import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int result;
	
	static int[] match_word_num = new int[58];
	static int[] find_word_num = new int[58];

	static int match_word_len;
	static int find_word_len;
	static char[] match_word;
	static char[] find_word;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		match_word_len = sc.nextInt();
		find_word_len = sc.nextInt();
		
		match_word = new char[match_word_len];
		find_word = new char[find_word_len];
		
		match_word = sc.next().toCharArray();
		find_word = sc.next().toCharArray();
		
		for(int i=0;i<match_word_len;i++) {
			match_word_num[(match_word[i]-'A')]++;
		}

		
		matching();
		System.out.println(result);
	}
	
	
	//단어 매칭 
	//0~57가지 문자열(순열)의 알파벳을 숫자로 저장하고, -> 순열 돌릴 필요가 없음 왜냐, 똑같은 숫자를 가지면 조합할 수 있다는 뜻이니까
	//긴문자열을 하나씩 저장하면서 숫자로 변환 -> 4개가 되면 숫자비교 
	//비교 끝나면 start 부분의 문자열 숫자를 -1하고, start + 1

	public static void matching() {
		
		int start = 0;
		int count = 0;//내가 find_word_num에 넣은 문자갯수 
		
		for(int i=0;i<find_word_len;i++) {
			find_word_num[find_word[i]-'A']+=1; //문자를 계속 넣는다.
			count++;
			
			if(count == match_word_len) {
				//문자열 비교
				if(Arrays.equals(match_word_num, find_word_num)) {
					result++;
				}
				find_word_num[find_word[start]-'A']-=1; //첫 값 빼주고 
				start++; // 새로운 시작점 
				count--; // count 하나 빼주고 
			}
		}
	}

}