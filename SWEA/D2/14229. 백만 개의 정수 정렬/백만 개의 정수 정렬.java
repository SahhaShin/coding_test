import java.util.Scanner;

public class Solution {
	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];//임시 배열
		mergeSort(arr,tmp,0,arr.length-1);//배열, 임시배열, 시작, 끝 전달 
		//본격적인 재귀 호출 시작 
	}
	
	//분할과정 
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		//시작인덱스가 끝 인덱스보다 작을 동안만 재귀호출을 할 것이다.
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(arr,tmp,start,mid);//이분할의 앞쪽 
			mergeSort(arr,tmp,mid+1,end);//이분할의 뒷쪽 
			
			//재귀가 돌아왔을 때는 왼쪽과 오른쪽이 정렬되어 돌아와야 한다.
			merge(arr,tmp,start,mid,end);		
		}
	}

	//병합과정 
	//arr : 배열, 정렬된 결과를 반복적으로 저장하고 있는 배열의 포인터 
	//tmp : 임시저장장소 
	//mid : 파티션을 나눴던 중간 인덱스 
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		//임시저장소에 필요한 만큼 배열을 복사해준다.
		for(int i=start;i<=end;i++) {
			tmp[i]=arr[i];
		}
		//배열이 중간지점을 기점으로 하나로 붙어있다. 
		int part1 = start;//첫번째 배열방의 첫번째 방 인덱스 
		int part2 = mid+1;//두번째 배열방의 첫번째 방 인덱스 
		
		//양쪽 방에서 작은 배열 값을 하나씩 복사할 때마다 결과 배열방에 어디에 저장하는지 index
		//작은거 값 복사 후 다음엔 어디 저장해야하는지 기억하고 있는다. 
		int index = start;
		
		//첫번째 배열이 끝까지 가거나 두번째 배열이 끝까지 갈 때까지 반복문을 돌린다.
		//이 둘 중 하나가 끝까지 가면 끝난다.
		while(part1<=mid && part2 <= end) {
			//첫번째 배열의 첫값보다 두번째 배열의 첫값이 크거나 같다면 
			if(tmp[part1]<=tmp[part2]) {
				arr[index]=tmp[part1];//작은 게 먼저 arr 차지 
				part1++;//첫번째 방 위치를 다음으로 옮긴다.
			}
			else {
				//두번째 배열 값이 더 작다면 
				arr[index]=tmp[part2];//작은 게 먼저 arr 차지 
				part2++;//두 번째 방 위치를 다음으로 옮긴다.
			}
			index++; //arr 배열의 다음 값을 넣으러 간다.
		}
		
		//만약 2번째 배열은 arr다 넣었는데, 1번째 배열의 값이 아직 남아있다면?
		//1번 배열의 마지막 mid인덱스에서 첫번째 배열이 찬만큼 빼준만큼 돌린다.
		for(int i=0;i<=mid-part1;i++) {
			arr[index+i]=tmp[part1+i];//남은값 붙여주기 
		}
		
		//반대로 뒷쪽배열이 아직 남아있다면?
		//2번째 배열은 최종배열의 뒷쪽에 이미 자리하고 있기 때문에 신경안써도 된다.
		
	}
	
	//결과 호출 프린터
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[1000000];
		for(int i=0;i<1000000;i++) {
			nums[i]=sc.nextInt();
		}
		mergeSort(nums);
		System.out.println(nums[500000]);
	}

}