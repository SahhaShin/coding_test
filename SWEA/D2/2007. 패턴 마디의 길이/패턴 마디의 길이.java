import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			String statement = sc.next();
			int result=0;//패턴 반복이 가장 많았던 횟수
			
			//2. for i -> 1~10개의 길이를 가진 패턴 텍스트를 만든다.
			for(int i=1;i<=10;i++) {
				int start_idx=0;
				int end_idx=i;
				String pattern=statement.substring(start_idx,end_idx);
				//System.out.println("start "+pattern);
				//3.패턴 텍스트를 돌려서 연속되는지 확인
				//패턴 길이만큼 돌리면서 연속적으로 맞는지 확인 
				int idx_end=statement.length()-pattern.length()+1;//패턴 검사 마지막 인덱스 
				int count=0;//패턴이 몇 번 반복되는지 
				boolean flag=true; //패턴이 끝까지 반복된다.
				
				check:for(int j=0;j<idx_end;j++) {
					for(int k=0;k<pattern.length();k++) {
						//문자열 부분 요소와 패턴 요소가 같은지 확인 
						//System.out.println(statement.charAt(k+j)+" vs "+pattern.charAt(k));
						if(statement.charAt(k+j)!=pattern.charAt(k)) {
							//for문을 나가서 다른 길이의 패턴을 가져온다.
							flag=false;
							break check;
						}
					}
					//패턴과 동일한 statement를 만나고 여기 왔다면 다음 패턴 검사를 위해 그만큼 인덱스를 늘려준다.
					j+=pattern.length()-1;//이미 위에서 j는 ++되어있는 상태 
				}//check end
				
				//4. flag가 끝까지 true 
				//패턴 그만 만들고 결과 출력 
				if(flag) {
					result=i;
					break;
				}
			}//패턴 특정 길이 선정 for end
			
			//결과 출력
			System.out.println("#"+T+" "+result);
			
		}//test case end
	}
}