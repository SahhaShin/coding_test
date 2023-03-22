import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] arr;
	static int[] arr_copy;
	
	/** 병합 정렬 - 분할 과정
	 * 자료를 최소 단위의 문제까지 나눈 후에 차례대로 정렬하여 최종 결과를 얻어냄.
	 * start : 왼쪽 파티션 시작 인덱스 || 오른쪽 파티션 시작 인덱스
	 * end : 왼쪽 파티션 끝 인덱스 || 오른쪽 파티션 끝 인덱스
	 * mid : 왼쪽 파티션의 중간 인덱스 || 오른쪽 파티션의 중간 인덱스
	 */
	static public void mergeSort(int start, int end) {
		//왼쪽 파티션 시작 인덱스가 오른쪽 파티션 시작 인덱스와 같아지거나 넘어가면 끝
		if(start>=end) return;
		
		//L<R이면 정상 조건이므로 시작
		int mid  = (start+end)/2;
		
		//왼쪽과 오른쪽으로 파티셔닝 해줄 것임(나눌 것임)
		//L   M   R
		mergeSort(start,mid);//왼쪽 파티셔닝의 시작값은 L, 끝값은 M이다.
		mergeSort(mid+1,end);//오른쪽 파티셔닝의 시작값은 M, 끝값은 R이다.
		
		/** 왼쪽 파티션 파티셔닝 하는 과정 (배열인덱스 0~7)
		 * n회 분할 : start/end/new mid(새롭게 나온 미들값) => 다음 턴 왼쪽 파티션 end가 됨
		 * 1회 분할 :  0 / 3 / (0+3)/2=1 -> 0~3 인덱스 오른쪽 분할 (2/3/2 -> 3/3/3 return)
		 * 2회 분할 :  0 / 1 / (0+1)/2=0 -> 0~1 인덱스 오른쪽 분할 (1/1/1 return) -> 1회 병합(start : 0/ mid : 1 /  end: 1)
		 * 3회 분할 :  0 / 0 / (0+0)/2=0 -> return 2회 분할로 돌아감  
		 * */
		mergeSort(start, mid, end);
	}
	
	/** 병합 정렬 - 병합 과정
	 * 분리된 2개의 파티셔닝을 비교하여 작은값을 선택해 앞에 배치한다.
	 * 1회 병합(start : 0/ mid : 1 /  end: 1)
	 * 0번 인덱스 값 > 1번 인덱스 값 => 1번 인덱스 값을 택해 만들어준 임시 배열(임시 배열 인덱스 변수(idx++)를 이용해)에 저장한다.
	 * 임시배열은 원본 배열 복사해둔 것임
	 * 한쪽 파티션의 원소를 다 봤으면 while 끝
	 * 무조건 둘 중 하나는 원소가 남아있을 것임 4개 비교해서 넣는데, 한쪽 2개 끝나면 한쪽 1개 남을 거니까
	 * 근데 왼쪽 파티션의 원소가 남았다면 임시배열 마지막에 추가해주면됨
	 * 근데 오른쪽 파티션의 원소가 남았다면 원본 배열 복사해 준 임시배열이기 때문에 구지 추가해줄 필요 없음 
	 * (병합 과정에서 파티션은 정렬된 상태로 오기 때문에 순차적으로 남은 값들을 넣어주면 됨)
	 * */
	static public void mergeSort(int start, int mid, int end) {
		//System.out.println(start + " " + mid + " "+end);
		int idx=start;//들어온 배열의 시작값 인덱스부터 넣어주자
		int L = start; //왼쪽 시작영역
		int R = mid+1; //오른쪽 시작영역
		//어느 한 쪽이 다 빌 때까지 시행
		//왼쪽 시작 인덱스가 오른쪽 시작 인덱스보다 작을 때
		while(L<=mid && R<=end) {
			//left 파티션의 시작점  start, 끝점 mid
			//right 파티션의 시작점 mid+1, 끝점 end
			if(arr[L]>arr[R]) {//오른쪽 파티션 요소 넣어줌
				arr_copy[idx]=arr[R];//작은 것을 먼저 넣어준다.
				R++;//다음 오른쪽 요소
			}
			else {
				arr_copy[idx]=arr[L];//작은 것을 먼저 넣어준다.
				L++;//다음 왼쪽 요소
			}
			idx++;
		}
		
		//비교 끝나고 넣어준 후에도 분명 왼 / 오 파티션 중 하나는 비어있음
		//그게 왼쪽 파티션일 때만 뒤에 추가
		//왼쪽 파티션의 끝값인 mid 위치보다 작거나 같다면 아직 안빠진 요소가 있다는 뜻 
		while (L <= mid) {
			arr_copy[idx++]=arr[L];//작은 것을 먼저 넣어준다.
			L++;//다음 왼쪽 요소
		}
		
		//원본에 반영한다. 가져온 배열의 끝값까지 !
		
//		System.out.println("현재상태");
//		System.out.println(Arrays.toString(arr_copy));
		
		//복사중
		//end가 포함되어야함 꼭!!! 
		for(int i=start;i<=end;i++) {
			arr[i]=arr_copy[i];
		}
		
//		System.out.println("복사상태");
//		System.out.println(Arrays.toString(arr));
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr=new int[1000000];
		arr_copy=new int[1000000];
		for(int i=0;i<1000000;i++) {
			arr[i]=sc.nextInt();
			arr_copy[i] = arr[i];
		}
		mergeSort(0,1000000-1);
		System.out.println(arr[500000]);
//		for(int i=0;i<10;i++) {
//			System.out.print(arr_copy[i]+" ");
//		}
	}

}