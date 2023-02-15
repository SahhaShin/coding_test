/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static int sdock_check(String mode, int[][]sdocu, int row_i, int col_j) {
		int[] numbers = new int[10]; // 1~10까지 동일한 수가 있는지 체크 
		Arrays.fill(numbers, 0);
		int index;
		
		switch(mode) {
		case "row":
		//row check
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++){
				index=sdocu[i][j];
				if(numbers[index]==0) numbers[index]++;
				else return 0;
			}	
			Arrays.fill(numbers, 0);
		}
		return 1;
	
		case "col":
		//col check
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				index=sdocu[j][i];
				if(numbers[index]==0) numbers[index]++;
				else return 0;
			}
			Arrays.fill(numbers, 0);
				
		}
		return 1;
	
		case "three":
		//3x3 check
		for(int i=row_i;i<row_i+3;i++) {
			for(int j=col_j;j<col_j+3;j++) {
			index=sdocu[i][j];
			if(numbers[index]==0) numbers[index]++;
			else return 0;
			}	
		}
		return 1;
		}//switch end 
	return 1;
}
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
	String sdocu;
	int[][] sdocu_list = new int[10][10]; // 9x9 
	int T;
	T=sc.nextInt();//test_case 
	sc.nextLine(); // 개행문자 입력 방지 
	int result;
	/*
	여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/
	
	for(int test_case = 1; test_case <= T; test_case++)
	{
	
		//스토쿠 입력 
		for(int i=1;i<10;i++) {
			sdocu=sc.nextLine();
			StringTokenizer sdocu_st = new StringTokenizer(sdocu);
			for(int j=1;j<10;j++) 
			sdocu_list[i][j]=Integer.parseInt(sdocu_st.nextToken());
		}
		
		//row check
		result=sdock_check("row", sdocu_list, 0, 0);
		
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		
		//col check
		result=sdock_check("col", sdocu_list, 0, 0);
		
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		
		//3x3 check
		result=sdock_check("three", sdocu_list, 1, 1);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		result=sdock_check("three", sdocu_list, 1, 4);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		result=sdock_check("three", sdocu_list, 1, 7);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		
		result=sdock_check("three", sdocu_list, 4, 1);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		result=sdock_check("three", sdocu_list, 4, 4);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		result=sdock_check("three", sdocu_list, 4, 7);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		
		result=sdock_check("three", sdocu_list, 7, 1);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		result=sdock_check("three", sdocu_list, 7, 4);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		result=sdock_check("three", sdocu_list, 7, 7);
		//0,1 check
		if(result==0) {
			System.out.println("#"+test_case+" "+result);
			continue;
		}
		
		System.out.println("#"+test_case+" "+result);
		


		}
	}
}