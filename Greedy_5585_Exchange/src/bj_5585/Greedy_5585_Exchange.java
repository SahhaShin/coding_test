package bj_5585;

import java.util.Scanner;

public class Greedy_5585_Exchange {

	public static void main(String[] args) {
		//1. 1000엔을 기본적으로 냄
		int pay=1000;
		
		Scanner sc = new Scanner(System.in);
		
		//2. 상품 가격 
		int price = sc.nextInt();
		
		//3. 500엔, 100엔, 50엔, 10엔, 5엔, 1엔 중 무조건 큰거!!!
		int[] exchange_list= {500,100,50,10,5,1};
		int exchange = pay-price;
		int result=0;
		while(exchange>0) {
			for(int i=0;i<exchange_list.length;i++) {
				if(price>0) {
					result+=exchange/exchange_list[i];
					exchange%=exchange_list[i];
					
				}
				else {
					break;
				}
			}
		}
		System.out.println(result);
	}

}
