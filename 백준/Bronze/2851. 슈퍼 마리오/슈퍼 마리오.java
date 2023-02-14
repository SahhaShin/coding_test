import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10개버섯 -> 점수
		//버섯을 순서대로 먹어야함 -> 중간에 멈출 수 있음
		//첫번째 버섯 안먹을 수 있음
		//점수는 100보다 작거나 같음
		
		//1. 버섯의 점수 입력 받기 
		int[] score = new int[10];
		for(int i=0;i<10;i++) {
			score[i]=sc.nextInt();
		}
		
		//2. 최대한 100에 가깝게 점수 만들기
		//결과는 98 102가 있다면 큰 값 선택 
		
		//case1.100보다 커지면 멈추기 
		//case2. 100보다 커져도 1번 먹어보고 이전 값과 차이 비교
		int result=0;
		int result_idx=0;
		//while로 하면 모두 0 00 0 0 받을 때 못나옴 
		for(int i=0;i<10;i++) {
			result+=score[i];
			if(result>=100) {
				result_idx=i;
				break;
			}
			
		}//100이거나 100보다 큰 상태로 나온다. 
		
		if(result==100) System.out.println(100);
		else {
			//100보다 큰 상태일 경우 바로 전단계 계산 값 빼주기 
			int result_before = result-score[result_idx];
			
			//result_after와 result 를 100과 차이가 같은지 확인
			//같다면 큰 값 선택 
			int result1 = -(100-result); //result는 100보다 큰 상태 
			int result2 = 100-result_before; //result_before 100보다 작은 값 
			if(result1==result2) System.out.println(result);
			else if(result1<result2) System.out.println(result);//result1이 100과 차이가작다.
			else System.out.println(result_before);
		}

	}

}
