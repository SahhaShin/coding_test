import java.util.Scanner;

public class Solution {
	static String[] arr;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int T=1;T<11;T++) {
			//1. 트리가 갖는 총 정점 수
			int count = sc.nextInt();
			sc.nextLine(); //개행문자 방지
			
			//arr 초기화 
			arr = new String[count+1];
			arr[0]=null;
			n=count;
			
			//2. 데이터 받고, 배열 정리 
			for(int i=0;i<count;i++) {
				String[] line = sc.nextLine().split(" ");
				
				int num = Integer.parseInt(line[0]);
				String alpha = line[1];
			
				int prev = -1;
				int next = -1;
				
				//있을 수도 없을 수도 있는 입력 
				if(line.length==3) {prev = Integer.parseInt(line[2]);}
				else if(line.length==4) {
					prev = Integer.parseInt(line[2]);
					next = Integer.parseInt(line[3]);
				}

				arr[num]=alpha;
				

			}
			//3. 중위순회
			System.out.print("#"+T+" ");
			traverse(1);
            System.out.println();
		}//test case end
		
			
			
			
	}// main end
	
	private static void traverse(int i) {
		//i번째 노드의 순회
		if(i<=n) {
			// 중위 순회
			//L : 왼쪽 트리로 탐색을 이어나감
			traverse(i*2);
			
			// V : 자기 자신을 방문처리
			if(arr[i]!=null) {
				System.out.print(arr[i]);
			}
			
			//R : 오른쪽 트리로 탐색을 이어나감
			traverse(i*2+1);
		}
		
	}

}