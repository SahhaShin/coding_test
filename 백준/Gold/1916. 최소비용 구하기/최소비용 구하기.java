import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static List<Country>[] countryList;//N번 도시에서 갈 수 있는 인접 도시들 표기
	static int result=0;
	static int busCount,cityCount;
	static int startLocation,endLocation;
	
	static class Country implements Comparable<Country>{
		int num;
		int fee;
		public Country(int num, int fee) {
			this.num=num;
			this.fee=fee;
		}
		
		@Override
		public int compareTo(Country o) {
			return Integer.compare(this.fee, o.fee);
		}

		@Override
		public String toString() {
			return "Country [num=" + num + ", fee=" + fee + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		cityCount = Integer.parseInt(br.readLine());
		busCount = Integer.parseInt(br.readLine());
		
		//countryList 인덱스 초기화
		countryList = new ArrayList[cityCount+1];
		for(int i = 1; i<=cityCount; i++) {
			countryList[i] = new ArrayList<>();
		}
		
		//버스 정보 입력받기 
		for(int turn = 0; turn<busCount;turn++) {
			String info = br.readLine();
			StringTokenizer st = new StringTokenizer(info," ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			
			countryList[start].add(new Country(end, fee));
		}
		
		//출발지 도착지 받기
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		startLocation = Integer.parseInt(st.nextToken());
		endLocation = Integer.parseInt(st.nextToken());
		
		//가장 최소 비용으로 갈 수 있는 거리 책정
		dijkstra(startLocation);
		
		//결과 출력
		System.out.println(result);
		
		//초기화
		result=0;
		
		
	}

	
	public static void dijkstra(int startCountry) {
		Queue<Country> pq = new PriorityQueue<>();
		int[] minimumFee = new int[cityCount+1];
		
		//1. 비용 무한대로 초기화
		Arrays.fill(minimumFee, Integer.MAX_VALUE);
		
		//2. 첫 노드를 정해서, pq에 넣어준다.
		minimumFee[startCountry]=0;//시작지점은 거리가 0이다. 그러므로 버스 비용도 0이다.
		pq.offer(new Country(startCountry,0));
		
		//3. pq가 빌 때까지 최소비용 계산을 진행한다.
		while(!pq.isEmpty()) {
			//4. 가장 비용이 작은 노드를 꺼낸다.
			Country nowCountry = pq.poll();
			int now = nowCountry.num;
			int nowFee = nowCountry.fee;
			
			if(now==endLocation)break;
			

			//5. 현재 노드와 인접한 노드의 비용 갱신
			//지금까지 내가 최소 비용이라고 계산한 금액(현재노드) + 가려고 하는 도시에 필요한 금액(다음노드) vs 지금까지 내가 최소 비용이라고 계산한 금액(다음노드)
			for(int i=0; i<countryList[now].size(); i++) {
				int next = countryList[now].get(i).num;
				int nextFee = countryList[now].get(i).fee;
				if(minimumFee[now]+nextFee < minimumFee[next]) {
					minimumFee[next]=minimumFee[now]+nextFee;
					pq.add(new Country(next,minimumFee[next]));
				}
				
					
			}

		}
		//minimumFee의 의미 : 해당 인덱스 번호 지역까지 가는데 최소 비용이다.
		result = minimumFee[endLocation];
	
	}
}