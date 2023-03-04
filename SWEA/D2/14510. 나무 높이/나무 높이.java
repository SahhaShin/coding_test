import java.util.Scanner;

public class Solution {
	//하루에 한 나무에 물을 줄 수 있다.
	
	//홀수번째에는 차가 가장 큰 홀수를 뺀다. 홀수가 없으면 짝수 중 가장 큰 값을 뺀다.
	//짝수번째에는 차가 가장 큰 짝수를 뺀다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2.나무갯수와 나무높이 & 가장 키 큰 나무 저장 
			int n =sc.nextInt();
			int[] grd = new int[n+1];//1~n번 나무 
			int max = 0;
			int max_idx=0;
			for(int i=1;i<=n;i++) {
				grd[i]=sc.nextInt();//키를 받음 
				if(max<grd[i]) {
					max=grd[i];//가장 키 큰 나무 구하기 
					max_idx = i;
				}
			}
			
			//3. 가장 키 큰 나무와 비교했을 때 필요한 키 저장 
			int[] need = new int[n+1];
			int count=0;//키 변화가 필요한 나무 수 
			for(int i=1;i<=n;i++) {
				if(max_idx!=i) {
					need[i]=grd[max_idx]-grd[i];
					if(need[i]!=0) count++;
				}
			}
			
			//3. 연산 
			//홀수번째에는 차가 가장 큰 홀수를 뺀다. 홀수가 없으면 짝수 중 가장 큰 값을 뺀다.
			//짝수번째에는 차가 가장 큰 짝수를 뺀다.
			
			int day=0;
			int i=0;
			
			while(count>0) {
				int[][] hole = new int[1][2]; //홀수 차 중 가장 큰  인덱스 , 값 
				int[][] zzak=new int[1][2];//짝수 차 중 가장 큰 인덱스, 값 
				i++;
				day++;
				
				//홀수 +1
				if(i%2==1) {
					for(int j=1;j<=n;j++) {
						//홀수중 가장 큰 애 {인덱스, 값} 저장 -> 없으면 짝수 중 가장 큰 애 
						//또한 이제 키가 필요하지 않는 나무의 경우 제외 
						if(need[j]%2==1 && hole[0][1]<need[j] && need[j]!=0) {
							hole[0][0]=j;
							hole[0][1]=need[j];
						}
						else if(need[j]%2==0 && zzak[0][1]<need[j] && need[j]!=0) {
							zzak[0][0]=j;
							zzak[0][1]=need[j];
						}
					}
					//홀수 중 가장 큰 애가 없으면 짝수로 
					if(hole[0][0]==0) {
						//count 1남았고, 짝수라면 , 홀수번째 들어왔을 때 건너뛴다.
						if(count>1)need[zzak[0][0]]--;
						
						if(need[zzak[0][0]]==0) {
							count--;//키 변화가 필요한 나무 수를 줄인다.
						}
					}
					else {
						//홀수 중 가장 큰 애가 있으면 그 애로
						need[hole[0][0]]--;
						if(need[hole[0][0]]==0) {
							count--;//키 변화가 필요한 나무 수를 줄인다.
						}
					}
				}//홀수 end
				
				//짝수 +1
				else if(i%2==0) {
					for(int j=1;j<=n;j++) {
						//짝수중 가장 큰 애 인덱스, 값 저장 -> 없으면 짝수 중 가장 큰 애 
						//또한 이제 키가 필요하지 않는 나무의 경우 제외
						if(need[j]%2==1 && hole[0][1]<need[j] && need[j]!=0) {
							hole[0][0]=j;
							hole[0][1]=need[j];
						}
						if(need[j]%2==0 && zzak[0][1]<need[j] && need[j]!=0) {
							zzak[0][0]=j;
							zzak[0][1]=need[j];
						}
					}
					//짝수 중 가장 큰 애가 없으면 홀수로 
					if(zzak[0][0]==0) {
						if(need[hole[0][0]]>=2)need[hole[0][0]]-=2;
						if(need[hole[0][0]]==0) {
							count--;//키 변화가 필요한 나무 수를 줄인다.
						}
					}
					else {
						//홀수 중 가장 큰 애가 있으면 그 애로
						if(need[zzak[0][0]]>=2)need[zzak[0][0]]-=2;
						if(need[zzak[0][0]]==0) {
							count--;//키 변화가 필요한 나무 수를 줄인다.
						}
					}
				}//짝수 end
			}//전체 for end
			System.out.println("#"+T+" "+day);
		}//test case end

	}

}
