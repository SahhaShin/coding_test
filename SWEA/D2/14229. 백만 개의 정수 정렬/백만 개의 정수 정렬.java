import java.util.Scanner;

public class Solution {
	//퀵정렬로 풀어보자
    
	private static void quickSort(int[] arr) {
		//arr, 첫값 , 끝값 
		//재귀 시작 
		quickSort(arr,0,arr.length-1);
	}
	private static void quickSort(int[] arr, int start, int end) {
		//배열 방의 시작과 끝 영역 안에서 파티션을 나누고, 
		//파티션의 오른쪽 방 첫번째 값을 받아올 것이다.
		int part2 = partition(arr,start,end);
		
		//오른쪽 파티션이 시작점 바로 다음에서 시작한다면 
		//왼쪽 파티션의 데이터는 하나라는 소리다.
		//즉 정렬할 필요가 없다.
		
		//때문에 오른쪽 파티션이 시작점에서 한개 이상 차이가 날 때만 돈다.
		if(start<part2-1) {
			quickSort(arr,start,part2-1);//첫번째 파티션 start~2번째 파티션 시작점 전 
		}
		if(part2<end) {
			//오른쪽 배열방의 파티션이 1개 이상일 때만 호출
			quickSort(arr,part2,end);//2번째 파티션 
		}
		
	}
	
	//배열방의 파티션을 나누는 함수 
	private static int partition(int[] arr, int start, int end) {
		//피봇은 배열의 중간으로 한다.
		int pivot = arr[(start+end)/2];
		
		//시작점이 끝지점보다 작거나 같을 때만 반복
		while(start<=end) {
			//시작 지점에서 시작하는 포인트는 배열방의 값이 피봇값보다 작으면 무시하고 계속 넘어간다.
			//시작지점에서 시작하는 포인트의 배열방의 값이 피봇값보다 크면 스탑
			while(arr[start]<pivot) start++;
			
			//엔드포인트는 맨끝에서부터 배열방의 값이 피봇값보다 크면 무시하고 계속 건너뛰어 앞쪽으로 온다.
			//엔드포인트의 배열방의 값이 피봇값보다 작으면 스탑 
			while(arr[end]>pivot)end--;
			
			//돌던 시작점과 끝값이 서로 만났다가 지나치지 않았는지 확인하고,
			if(start<=end) {
				//만나거나 지나치지 않았다면 두 값을 스왑한다.
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		
		//위 과정을 만나거나 지나칠때까지 반복하면 스타트 포인터에 
		//새로 나눌 오른쪽 파티션의 첫번째 배열방 인덱스가 들어간다.
		return start;
	}
	
	//2개의 데이터 스왑 
	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end]=tmp;
		
	}
	
	//배열 출력 함수
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data+", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums=new int[1000000];
		for(int i=0;i<1000000;i++) {
			nums[i]=sc.nextInt();
		}
		quickSort(nums);
		System.out.println(nums[500000]);
	}
}