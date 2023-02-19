//1000 , 1001 , 10998 , 10869
//#include<stdio.h>
//
//int main() {
//	int a = 0;
//	int b = 0;
//	scanf("%d%d", &a, &b);
//	printf("%d\n", a + b);
//	printf("%d\n", a - b);
//	printf("%d\n", a * b);
//	printf("%d\n", a / b);
//	printf("%d\n", a % b);
//	return 0;
//}

//1008
//#include<stdio.h>
//
//int main() {
//	
//	double a = 0;
//	double b = 0;
//	scanf("%lf%lf", &a, &b);
//
//	printf("%.10lf", a / b);
//
//	return 0;
//}

//1110
//#include<stdio.h>
//int main() {
//	int some = 0;
//	
//	int sum = -1; //someÀÌ 0ÀÏ¶§ while ¾Èµ¹¾Æ°¨
//	int copy = 0;
//	int cycle = 0;
//
//	scanf("%d", &some);
//
//	copy = some;
//
//	while (sum != some) {
//		if (copy >= 0 && copy <= 99) {
//			sum = (copy / 10) + (copy % 10);
//			if (sum < 10) {
//				sum = (copy%10)*10+sum;
//				
//			}
//			else {
//				sum = (copy % 10)*10 + (sum % 10);
//				
//			}
//
//			copy = sum;
//			
//		}
//		cycle++;
//	}
//	printf("%d", cycle);
//	
//	return 0;
//}

//2753¹ø
//#include<stdio.h>
//int main() {
//	int year = 0;
//
//	scanf("%d", &year);
//
//	//À±³â
//	if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
//		printf("1");
//	}
//	else {
//		printf("0");
//	}
//}

//2839
#include<stdio.h>
int main() {
	int num = 0;
	int copy = 0;
	int each = 0;
	scanf("%d", &num);
	copy = num;
	int quo_5 = copy/5;

	while (copy > 0) {
		if ((copy - (quo_5 * 5)) % 3 == 0 && quo_5>=0) {
			copy = copy - (quo_5 * 5);
			for (int i = 1; i < 1700; i++) {
				if (copy > 0) {
					copy = copy - 3;
					each = i;
				}
					
			}
		}
		else {
			if (quo_5 < 0) {
				printf("-1");
				return 0;
			}
			else
			{
				quo_5--;
			}
			
		}
		
	}
	each = each + quo_5;
	printf("%d", each);
	return 0;
}
