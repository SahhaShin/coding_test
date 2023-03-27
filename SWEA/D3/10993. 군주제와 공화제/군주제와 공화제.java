import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static class country{
		int x;//나라 위치 x
		int y;//나라 위치 y
		int s;//군사력 
		int count;//지배자 명수 
		double[] owner;//index 국가 속국으로써 얼마만큼의 영향력을 받고 있는지 (0번인덱스 국가 속국으로 2의 영향력을 받고 있다.)
		double top=-1.0;//제일 힘이 쎈 지배자 영향력 
		int top_idx=-1;//제일 힘이 쌘 지배자 인덱스 
		
		country(int x, int y, int s){
			this.x=x;
			this.y=y;
			this.s=s;
		}

	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt(); //test case

		for(int T=1;T<test+1;T++) {
			int N = sc.nextInt();//도시갯수
			
			country[] countryInfo = new country[N];
			country[][] countryKing = new country[N][N];//(0,1) 0번도시에 1번도시는 위협당한다.
			
			//나라 상황 입력 받기 
			for(int i=0;i<N;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int s = sc.nextInt();
				country newCountry = new country(x,y,s);
				countryInfo[i]=newCountry;
			}
			
			//owner 초기화
			for(int i=0;i<N;i++) {
				countryInfo[i].owner = new double[N];
			}
			
			//영향력 계산 나라 간의 관계 파악
			//도시 i가 다른 도시 j에 행사하는 영향력을, si / ( (xj - xi)2+(yj - yi)2 )
			//도시 i가 다른 도시 j에 행사하는 영향력이 그 도시의 군사력 si 초과라면, 도시 i는 도시 j를 위협한다. 
			//전체 경우의 수를 고려해줘야함 => 0->1과 1->0은 다르기 때문이다.
			for(int i =0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j) continue;
					
					double power_j = countryInfo[j].s/(Math.pow(countryInfo[i].x-countryInfo[j].x,2)+Math.pow(countryInfo[i].y-countryInfo[j].y,2));
					
					//도시 i가 도시 j를 위협한다.
					if(power_j>countryInfo[i].s) {
						countryInfo[i].owner[j]=power_j;//j가 i를 위협한다. power_i 영향력 행사 
						countryInfo[i].count++;//i의 지배자 추가 
						
						if(countryInfo[i].top<=power_j) {
							countryInfo[i].top=power_j;//가장힘이 썐 나라의 영향력
							countryInfo[i].top_idx=j;//가장 힘이 쌘 나라 
						}
					}
				
				}
			}
			
			//만약 도시 i가 어떠한 다른 도시에도 위협당하지 않는다면, 해당 도시의 사람들은 군주를 존경하고, 도시 i는 군주제를 유지한다.
			//만약 도시 i가 하나 이상의 도시들에 위협당하며, 이들 중 영향력이 가장 큰 도시가 유일하다 하자. 도시 i는 항복하고, 영향력이 가장 큰 유일한 도시 j의 체제를 따른다. 만약 위협하는 도시 j 역시 다른 도시 k에 항복했다면, 도시 k의 체제를 따르고, 이것이 계속되면 이를 반복하여 따라간다.
			//만약 도시 i가 하나 이상의 도시들에 위협당하며, 이들 중 영향력이 가장 큰 도시가 두 개 이상이라 하자. 도시의 사람들은 군주를 존경하지 않으며 어떤 도시에 복종해야 하는지 분열된 의견을 가진다. 고로 도시 i는 민주적인 공화제를 도입한다.
			//이 도시가 군주제를 유지한다면 K, 공화제를 유지한다면 D를 출력하고, 다른 도시의 체제를 따른다면, 그 도시의 번호를 출력
			
			System.out.print("#"+T+" ");
			//i국가는 어떤 통치 국가인가?
			for(int i=0;i<N;i++) {
				double max_power=0.0;//특정 국가에서 영향력이 가장 높은 국가의 영향력 
				int max_count=0;//특정 국가의 영향력을 가장 크게 행사하는 국가의 수 (1 = 속국 / 2 = 민주공화제)
				String result="";
				
				for(int j=0;j<N;j++) {
					if(i!=j) {
						
						//내가 i국가인데 지배자가 하나도 없다 -> 내가 지배자 
						if(countryInfo[i].count==0) {
							result="K";	
							break; 
						}
						
						//내가 i국가인데 지배자가 2국가 이상이다.
						else if(countryInfo[i].count>=2) {
							//i국가의 지배자 j의 힘이 0.0이 아니고,
							//가장 쌘 영향력을 갖고 있는 top값과 같으면 max_count+1을 시킨다. max_count는 지배자 수이다.
							if(countryInfo[i].owner[j]!=0.0&&countryInfo[i].owner[j]==countryInfo[i].top) {
								result=Integer.toString(j+1);//지배자 결정 -> 두 국가일 경우에는 안씀 / 한 국가일 때만 씀 
								max_count++;//지배자 수 
							}
						}
						
						else {
							//count가 1이면 아래로 내려옴
							//countryInfo[i].count>=2 결과에서 지배자수가 1명일 때랑 같이 연산해줄 것임 
							break;
						}
					}
				
				}

				if(max_count>=2) result="D";
				else {
					//지배자가 1명이면, 최종 지배자를 가려내야함
					//1번 국가를 2번 국가가 지배한다면, 2번 국가를 지배하는 국가를 찾아서 꼬리 물어야 함 
					int idx=i;
					while(countryInfo[idx].top_idx!=-1){
						result=Integer.toString(countryInfo[idx].top_idx+1);
						idx=countryInfo[idx].top_idx;
					}
				}
				
				//i번째 국가 존속이 결정될때마다 출력 
				System.out.print(result+" ");
			}
			System.out.println();
		
		}//test case end
	}

}