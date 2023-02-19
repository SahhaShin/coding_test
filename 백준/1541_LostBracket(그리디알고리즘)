package bj_1541;

import java.util.Scanner;

public class Greedy_1541_LostBracket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 식을 입력 받는다.
		//2. 마이너스 기준으로 split한다. (- 없어짐)
		String[] sentence = sc.nextLine().split("\\-");
		//3. index별로 더해줄 건 더해주기 
		int[] index_total = new int[sentence.length]; //index 별로 더한 값을 저장할 리스트 
		
		for(int i=0;i<sentence.length;i++) {
			//4. 숫자와 + 구분 (+는 없어짐)
			if(sentence[i].contains("+")) {
				//4-1. 만약 + 부호가 있으면 +로 구분하고 숫자로 변환하는 과정 필요 
				//\\표시 없으면 java.util.regex.PatternSyntaxException 뜸.  
				String[] sperate_plus = sentence[i].split("\\+");
				//5.모두 숫자로 바꿔 더해주기 
				for(int j=0;j<sperate_plus.length;j++) {
					//0009도 (int)로 형바꿈하면 에러나지만 Integer.parseInt("0009");로 하면 형바꿈 잘된다.
					index_total[i] += Integer.parseInt(sperate_plus[j]);
				}
			}
			else {
				//4-2. + 부호가 없으면 그냥 숫자로 변환하기 
				//0009도 (int)로 형바꿈하면 에러나지만 Integer.parseInt("0009");로 하면 형바꿈 잘된다.
				index_total[i]=Integer.parseInt(sentence[i]);
			}
				
		}
		//index 0번째 값은 초기에 들어가고, 1번 index부터 빼줄 것 
		int result=index_total[0];
		//6. 최종 인덱스별 합들을 마이너스해주기 
		for(int i=1;i<index_total.length;i++) {
			result-=index_total[i];
		}
		
		//7. 결과 출력
		System.out.println(result);
	}

}
