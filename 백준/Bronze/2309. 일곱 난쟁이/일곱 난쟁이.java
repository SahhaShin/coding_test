import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//난쟁이의 키합은 100 
		Scanner sc = new Scanner(System.in);
		int[] cm = new int[9];
		
		//키 받기 
		for(int i=0;i<9;i++) {
			cm[i]=sc.nextInt();
		}
		
		//브루트포스 
		Arrays.sort(cm);
		
		int[] result = new int[7];
		int total=0;
		
		go: for(int a=0;a<9;a++) {
			for(int b=0;b<9;b++) {
				if(b!=a) {
					for(int c=0;c<9;c++) {
						if(c!=a && c!=b) {
							for(int d=0;d<9;d++) {
								if(d!=a && d!=b && d!=c) {
									for(int e=0;e<9;e++) {
										if(e!=a && e!=b && e!=c && e!=d) {
											for(int f=0;f<9;f++) {
												if(f!=a && f!=b && f!=c && f!=d && f!=e) {
													for(int g=0;g<9;g++) {
														if(g!=a && g!=b && g!=c && g!=d && g!=e) {
															total=cm[a]+cm[b]+cm[c]+cm[d]+cm[e]+cm[f]+cm[g];
															if(total==100) {
																result[0]=cm[a];
																result[1]=cm[b];
																result[2]=cm[c];
																result[3]=cm[d];
																result[4]=cm[e];
																result[5]=cm[f];
																result[6]=cm[g];
																break go;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
				
		}
		
		Arrays.sort(result);
		for(int i=0;i<7;i++) {
			System.out.println(result[i]);
		}
	}
}