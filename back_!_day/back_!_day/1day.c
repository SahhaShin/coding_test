#include <stdio.h>
#include<stdlib.h>

//4�� 30�� ����
//https://www.acmicpc.net/problem/1966



int main() {
	
	//number�� �׽�Ʈ ���̽��̴�.
	int number = 0;
	scanf("%d",&number);
	int document_count = 0; //������ ����
	int document_question = 0; // ť ���°�� �ִ��� �ñ��� ����

	//�׽�Ʈ ���̽� ��ŭ for���� ���ư���.
	for (int i = 0; i < number; i++) {


		//������ ������ ť ���°�� �ִ��� �ñ��� ������ �޴´�.
		scanf("%d %d", &document_count, &document_question);

		int* primary = (int*)malloc(sizeof(int) * document_count);
		


		//�ϴ� ���� ������ŭ �߿䵵�� �޴´�.
		for (int j = 0; j < document_count; j++) {
			scanf("%d", primary + j);


		}

		int inter = 0;

		//���� ��ġ ã��
		int position = document_question;

		//�������� �߿䵵�� ���� ���ġ(0��° ������ ��� ������ ���Ͽ� 0��° �������� ū �߿䵵�� �ִٸ� �ǵڷ�)
		//�켱���� ���� Ŭ���� �켱������ ������
		for (int k = 0; k < document_count; k++) {
			
			for (int k_2 = k + 1; k_2 < document_count; k_2++) {
				

				//�񱳴�󺸴� ū �켱������ �ϳ��� �߰ߵǸ� �ǵڷ� �̵��ؾ���
				if (*(primary + k) < *(primary + k_2)) {

					inter = *(primary + k);
					//�ϳ��� �մ��� �񱳴���� �ǵڷ� ������.
					for (int k_3 = k; k_3 < document_count - 1; k_3++) {
						*(primary + k_3) = *(primary + k_3 + 1);
						if (k_3 + 1 == position) {
							position = k_3;

						}
					}
					*(primary + document_count - 1) = inter;

					if (position == 0) {
						position = document_count - 1;


					}


					k_2 = k;//�ǵڷ� ������ �ٽ� �ٷ� �����Ͱ� �񱳺��� ����

				}


			}
		}
		
		printf("%d\n", position + 1);
	
		free(primary);
		





		
	}


	
}


