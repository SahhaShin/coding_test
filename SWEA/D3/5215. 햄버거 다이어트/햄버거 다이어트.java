import java.util.Scanner;

public class Solution {
	static Ingredient[] InList;//재료리스트
	static int N,C;
	static int result;//높은 점수 저장
	static class Ingredient{
		int score;
		int calory;
		public Ingredient(int score, int calory) {
			super();
			this.score = score;
			this.calory = calory;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//test case 
		
		for(int T = 1;T<t+1;T++) {
			N = sc.nextInt();//재료 갯수
			C = sc.nextInt();//제한 칼로리
			
			//재료 갯수만큼 정보 받기
			InList = new Ingredient[N];
			for(int i=0;i<N;i++) {
				//점수와 칼로리 넣기
				InList[i]=new Ingredient(sc.nextInt(),sc.nextInt());
			}
			
			//입력 끝
			
			powerSet(0,0,0); //만족도 높은 햄버거 만들기
			
			System.out.println("#"+T+" "+result);//결과 출력
			
			result=0;//초기화
			
			
		}//test case end
	}

	/**
	 * 같은 재료 뽑으면 안됨 = 중복안됨
	 * 순서는 중요하지 않다. 1,3,5번 재료나 3,5,1번 재료나 같다.
	 * => 부분집합
	 * */
	
	public static void powerSet(int depth, int score, int calory) {
		//칼로리가 제한 칼로리보다 작으면 높은 점수 갱신
		if(calory<=C) {
			result=Math.max(score, result);
		}
		
		//칼로리가 제한 칼로리를 넘으면 그만!
		if(calory>C) return;
		
		if(depth == N) return; //모든 재료 고려 해줬다.
		
		//이 재료 선택
		powerSet(depth+1,score+InList[depth].score, calory+InList[depth].calory);
		
		//이 재료 선택 안함
		powerSet(depth+1,score, calory);
		
	}
}