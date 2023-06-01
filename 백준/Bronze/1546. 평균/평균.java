import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		double[] scores = new double[count];
		double maxScore = 0;
		
		for(int i=0;i<count;i++)
		{
			scores[i]=sc.nextInt();
			//최대값 구하기
			if(maxScore<scores[i]) maxScore=scores[i];
		}
		
		//입력 받기 끝
		
		//새로운 점수로 변환
		double totalSum=0;
		for(int i=0;i<count;i++)
		{
			scores[i] = scores[i]/maxScore*100;
			totalSum+=scores[i];
		}
		
		//새로운 평균 출력
		System.out.println(totalSum/count);
	}

}