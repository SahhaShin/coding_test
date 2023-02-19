#include<stdio.h>
#include<string.h>

int stack[10000] = { 0, };
int top_pointer=-1;

//push
void push(int x) {
	top_pointer++;
	stack[top_pointer] = x;
}
void pop() {
	if (top_pointer == -1)
		printf("%d\n", -1);
	else {
		printf("%d\n", stack[top_pointer]);
		top_pointer--;
	}

}
void top() {
	if (top_pointer == -1) {
		printf("%d\n", -1);
	}
	else
	{
		printf("%d\n", stack[top_pointer]);
	}
	
}
void size() {
	
	printf("%d\n", top_pointer+1);
}
void empty() {
	if (top_pointer == -1) {
		printf("%d\n", 1);
	}
	else {
		printf("%d\n", 0);
	}
}

int main() {
	int num = 0;
	char command[100] = { 0, };
	int x = 0 ;

	scanf("%d", &num);

	for (int i = 0; i < num; i++) {

		scanf("%s", command);
	
		if (strcmp(command, "pop") == 0)
			pop();
		else if (strcmp(command, "push") == 0) {
			scanf("%d", &x);
			push(x);
		}

		else if (strcmp(command, "size") == 0) {;
			size();
		}
			

		else if (strcmp(command, "empty")==0)
			empty();

		else if(strcmp(command, "top")==0)

			top();
		else {

		}
	}


	return 0;
}

