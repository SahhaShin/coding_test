#include<stdio.h>
#include<stdlib.h>
void linked(int a, int b);
struct birus {
	int computer;
	struct birus* next;
};

//��带 ����
struct birus* head[101] = { NULL, };

int one_index=0;
int main() {
	int comnum=0; //��ǻ�� ��
	int connect = 0; //����� ��ǻ�� ���� ��
	int a, b; //����� ��ǻ�� 1��
	int count = 0;//���̷��� �ɸ� ��ǻ�� ��

	scanf("%d", &comnum);
	scanf("%d", &connect);
	for (int i = 0; i < connect; i++) {
		scanf("%d %d", &a, &b);
		//����� ��ǻ�� 1���� ��ũ��� ������ش�.
		linked(a, b);
	}

	//���̷����� �ɸ� ��ǻ�� ����
	struct birus* next_node = (struct birus*)malloc(sizeof(struct birus));
	next_node = head[one_index];
	while (next_node != NULL) {
		count++;
		next_node = next_node->next;

	}

	printf("%d", count-1);

	


	printf("\n");
	next_node = head[0];
	while (next_node != NULL) {
		printf("%d\t", next_node->computer);
		next_node = next_node->next;

	}

	printf("\n");
	
	next_node = head[1];
	while (next_node != NULL) {
		printf("%d\t", next_node->computer);
		next_node = next_node->next;

	}
	printf("\n");
	next_node = head[2];
	while (next_node != NULL) {
		printf("%d\t", next_node->computer);
		next_node = next_node->next;

	}
	printf("\n");
	next_node = head[3];
	while (next_node != NULL) {
		printf("%d\t", next_node->computer);
		next_node = next_node->next;

	}


	return 0;
}













///////////////////////////////////////////////////////////////////////////
///////////////////////////////////��ũ�� ����Ʈ //////////////////////////

void linked(int a, int b) {
	
	int a_switch = NULL;
	int b_switch = NULL;
	struct birus* next_node = (struct birus*)malloc(sizeof(struct birus));


	//head�� �ƹ��͵� ������ �ƹ� �����͵� ���ٴ� ���Դϴ�.
	//���ο� head ����
	if (head[0] == NULL) {
		struct birus* a_node = (struct birus*)malloc(sizeof(struct birus));
		struct birus* b_node = (struct birus*)malloc(sizeof(struct birus));

		a_node->computer = a;
		b_node->computer = b;
		a_node->next = b_node;
		b_node->next = NULL;
		
		head[0] = a_node;
	
		head[0]->computer = a_node->computer;

		if (a == 1 || b == 1) {
			one_index = 0;
		}

	}
	else {
		//head�� null�� �ƴϸ� �� ���� �ִٴ� ��
		//head�� ���󰡼� ���� a��ǻ�Ͱ� �̹� �����ִٸ� ����x, ���ٸ� ���� o
		//head�� �ϳ��� �ƴϴ�. ���� ��� head�� �����Ѵ�.
		//����ġ�� 0�� �ƴϸ� ���ο� ��带 ������ �ʾƵ� �ȴٴ� ��, ����ġ�� ���ٰ� ǥ�õ� head�� �ε����� ����Ŵ
		for (int i = 0; i < 101; i++) {
			
			next_node = head[i];
			

			while (next_node != NULL) {

				if ((next_node->computer)==a) {
					
					a_switch = i+1;
					next_node = next_node->next;
			

				}
				else if ((next_node->computer) == b) {
					
					b_switch = i+1;
					next_node = next_node->next;
					
				}
				else {
					next_node = next_node->next;
					if (next_node == NULL)
						break;
				}
			}
		}
		//�Ѵ� �ش� ��ǻ�Ͱ� ������ ���ο� ��带 ���� ��, ���ο� ��忡 ����
		if ((a_switch == NULL) && (b_switch == NULL)) {
			struct birus* a_node = (struct birus*)malloc(sizeof(struct birus));
			struct birus* b_node = (struct birus*)malloc(sizeof(struct birus));

			a_node->computer = a;
			b_node->computer = b;
			a_node->next = b_node;
			b_node->next = NULL;

			//����ִ� head ã�� -> ���ο� head�� a_node�� ����
			for (int k = 0; k < 150; k++) {
				if (head[k] == NULL) {
					head[k] = a_node;
					if (a == 1 || b == 1) {
						one_index = k;
					}
					break;
				}
			}
			
			
			
		}

		//a��ǻ�ʹ� �ִµ� b ��ǻ�Ͱ� ������ a�� �ִ� head ���� b�� �߰��Ѵ�.
		else if ((a_switch != NULL) && (b_switch == NULL)) {
			struct birus* b_node = (struct birus*)malloc(sizeof(struct birus));
			b_node->computer = b;
			b_node->next = NULL;
			struct birus* next_a_node = (struct birus*)malloc(sizeof(struct birus));
			next_a_node = head[a_switch-1];
			while (next_a_node->next != NULL) {	
				next_a_node = next_a_node->next;			
			}

			next_a_node->next = b_node;

			if (a == 1 || b == 1) {
				one_index = a_switch-1;
			}
		
		}
		else if ((a_switch == NULL) && (b_switch != NULL)) {
			struct birus* a_node = (struct birus*)malloc(sizeof(struct birus));
			a_node->computer = b;
			a_node->next = NULL;
			struct birus* next_b_node = (struct birus*)malloc(sizeof(struct birus));//�����ؾ��� ���� ��带 �˷��ش�.
			next_b_node = head[b_switch-1];
			while (next_b_node->next != NULL) {

				next_b_node = next_b_node->next;

			}

			next_b_node->next=a_node;

			if (a == 1 || b == 1) {

				one_index = b_switch-1;
			}

		}
		else {
			//�� �� ������ ����ġ�� �Ѵ� ������ Ȯ��
			if (a_switch == b_switch) {
				//�ƹ��͵� ���ص� ��^^
			}
			else {
				//�� ������ ���� �����������
				//a�������� b�� �ٿ�����
				struct birus* next_a_node = (struct birus*)malloc(sizeof(struct birus));//�����ؾ��� ���� ��带 �˷��ش�.
				next_a_node = head[a_switch-1];
				while (next_a_node->next != NULL) {

					next_a_node = next_a_node->next;

				}
				next_a_node->next = head[b_switch-1];

				if (a == 1 || b == 1) {
					one_index = a_switch-1;
				}
			
			}
		}
	}

}