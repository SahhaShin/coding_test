import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Store> storeList=new ArrayList<>();
	static List<Integer> minDistance=new ArrayList<>();
	static int count;
	static int width;
	static int height;
	
	public static class Store{
		int x;
		int y;
		int direction;
		public Store(int x, int y, int direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}

	public static void main(String[] args) {
		//제한시간 1초 
		//동근이의 위치에 따라 최단 거리가 달라질 것 같음
		Scanner sc = new Scanner(System.in);
		
		width = sc.nextInt();
		height = sc.nextInt();
		
		count = sc.nextInt();
		
		//가게들의 위치 + 동근이의 위치 
		for(int i=0;i<count+1;i++) {
			int direction = sc.nextInt();
			int distance = sc.nextInt();
			
			//1:북 / 2:남 / 3:서 / 4:동 
			//즉, storeList 마지막에는 동근이의 위치가 있는 것 
			if(direction == 1) {
				storeList.add(new Store(0,distance,direction));
			}else if(direction == 2) {
				storeList.add(new Store(5,distance,direction));
			}else if(direction == 3) {
				storeList.add(new Store(distance,0,direction));
			}else if(direction == 4) {
				storeList.add(new Store(distance,5,direction));
			}
			
		}
		
		//입력 받기 끝 
		
		//가게 수대로 최단 거리 구해야함 
		//1:북 / 2:남 / 3:서 / 4:동 
		if(storeList.get(count).direction==1) {
			for(int i=0;i<count;i++) {
				NORTH(i);
			}
		}else if(storeList.get(count).direction==2) {
			for(int i=0;i<count;i++) {
				SOUTH(i);
			}
		}else if(storeList.get(count).direction==3) {
			for(int i=0;i<count;i++) {
				WEST(i);
			}
		}else if(storeList.get(count).direction==4) {
			for(int i=0;i<count;i++) {
				EAST(i);
			}
		}
		
		
		//총합 출력 
		int result = 0;
		for(int i=0;i<count;i++) {
			result += minDistance.get(i);
		}
		
		System.out.println(result);
	}
	
	//동근이가 동
	public static void EAST(int idx) {
		Store cur_store = storeList.get(idx);
		Store dong = storeList.get(count);
		
		//1:북 / 2:남 / 3:서 / 4:동 
		
		//동쪽 가게(?,y) == 같은 방향 
		if(cur_store.direction==4) {
			minDistance.add(Math.abs(cur_store.x-dong.x));
		}
		
		
		//서쪽 가게 == 맞은편 방향 
		else if(cur_store.direction==3) {
			int distance1 = dong.x+width+cur_store.x; //위 
			int distance2 = (height-dong.x)+width+(height-cur_store.x); //아래 
			minDistance.add(Math.min(distance1,distance2));
		}
		
		
		//남쪽 가게 == 아래쪽 방향 
		else if(cur_store.direction==2) {
			minDistance.add((height-dong.x)+(width-cur_store.y));
		}
		
		
		//북쪽 가게 == 위쪽 방향 
		else if(cur_store.direction==1) {
			minDistance.add((dong.x)+(width-cur_store.y));
		}
	}
	
	//동근이가 서
	public static void WEST(int idx) {
		Store cur_store = storeList.get(idx);
		Store dong = storeList.get(count);
		
		//1:북 / 2:남 / 3:서 / 4:동 
		
		//동쪽 가게 == 맞은편 방향 
		if(cur_store.direction==4) {
			int distance1 = dong.x+width+cur_store.x; //위 
			int distance2 = (height-dong.x)+width+(height-cur_store.x); //아래 
			minDistance.add(Math.min(distance1,distance2));
		}
		
		
		//서쪽 가게 == 같은 방향 
		else if(cur_store.direction==3) {
			minDistance.add(Math.abs(cur_store.x-dong.x));
		}
		
		
		//남쪽 가게 == 아래쪽 방향 
		else if(cur_store.direction==2) {
			minDistance.add((height-dong.x)+(cur_store.y));
		}
		
		
		//북쪽 가게 == 위쪽 방향 
		else if(cur_store.direction==1) {
			minDistance.add((dong.x)+(width-cur_store.y));
		}
	}
	
	//동근이가 남
	public static void SOUTH(int idx) {
		Store cur_store = storeList.get(idx);
		Store dong = storeList.get(count);
		
		//1:북 / 2:남 / 3:서 / 4:동 
		
		//동쪽 가게 == 오른쪽 방향 
		if(cur_store.direction==4) {
			minDistance.add((width - dong.y) + (height - cur_store.x));
		}
		
		
		//서쪽 가게 == 왼쪽 방향 
		else if(cur_store.direction==3) {
			minDistance.add(dong.y+(height-cur_store.x));
		}
		
		
		//남쪽 가게 == 같은 방향 
		else if(cur_store.direction==2) {
			minDistance.add(Math.abs(dong.y-cur_store.y));
		}
		
		
		//북쪽 가게 == 맞은편 방향 
		else if(cur_store.direction==1) {
			int distance1 = dong.y+height+cur_store.y; //왼쪽 
			int distance2 = (width-dong.y)+height+(width-cur_store.y); //오른쪽  
			minDistance.add(Math.min(distance1,distance2));
		}
	}
	
	//동근이가 북 
	public static void NORTH(int idx) {
		
		Store cur_store = storeList.get(idx);
		Store dong = storeList.get(count);
		
		//1:북 / 2:남 / 3:서 / 4:동 
		
		//동쪽 가게 == 오른쪽 방향 
		if(cur_store.direction==4) {
			minDistance.add((width - dong.y) + (cur_store.x));
		}
		
		
		//서쪽 가게 == 왼쪽 방향 
		else if(cur_store.direction==3) {
			minDistance.add(dong.y+cur_store.x);
		}
		
		//남쪽 가게 == 맞은편 방향 
		else if(cur_store.direction==2) {
			int distance1 = dong.y+height+cur_store.y; //왼쪽 
			int distance2 = (width-dong.y)+height+(width-cur_store.y); //오른쪽  
			minDistance.add(Math.min(distance1,distance2));
		}
		
		//북쪽 가게 == 같은 방향 
		else if(cur_store.direction==1) {
			minDistance.add(Math.abs(dong.y-cur_store.y));
		}
	}

}