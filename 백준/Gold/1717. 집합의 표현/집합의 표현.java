import java.util.Scanner;

public class Main {

	static int maxNum;
	static int[] parent;
	static int[] rank;
	
	static int calCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		maxNum = sc.nextInt();
		parent = new int[maxNum+1];
		rank = new int[maxNum+1];
		
		calCount = sc.nextInt();
		
		
		//시작 전 부모 초기 셋팅
		setP();
		
		for(int T=1;T<=calCount;T++) {
			int mode = sc.nextInt(); //0이면 합집합모드, 1이면 확인모드
			
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if(mode == 0) {
				//합집합 모드
				if(findP(num1)==findP(num2)) continue;
				
				union(num1, num2);
			}else if(mode == 1) {
				if(findP(num1)==findP(num2)) System.out.println("YES");
				else System.out.println("NO");
			}
			
		}

	}
	
	//크루스칼
	
	//부모를 자기 자신으로 셋팅
	public static void setP() {
		for(int i=1;i<=maxNum;i++) {
			parent[i]=i;
		}
	}
	
	//자식의 부모를 찾아준다
	public static int findP(int child) {
		if(parent[child]==child) return child;
		else return findP(parent[child]);
	}
	
	//합집합
	public static void union(int c1, int c2) {
		int c1_p = findP(c1);
		int c2_p = findP(c2);
		
		//둘의 부모가 다른 것만 들어온다고 가정
		
		if(rank[c1_p]>=rank[c2_p]) {
			parent[c2_p] = c1_p;
			rank[c1_p]++;
		}else {
			parent[c1_p] = c2_p;
			rank[c2_p]++;
		}
	}

}