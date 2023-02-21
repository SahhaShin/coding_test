import java.util.Scanner;
import java.util.Stack;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for (int T = 1; T < 11; T++) {
            //연산의 총 길이
            int len = sc.nextInt();
             
            //연산 문자열
            char[] operation = sc.next().toCharArray();
             
             
            // 1. 중위 표기식 -> 후기 표기식
            String last_change = last(operation);
            // 2. 후기 표기식 -> 전위로 바꾸며 계산
            int result=caluator(last_change);
             
            System.out.println("#"+T+" "+result);
        } // test case end
         
    }
    public static String last(char[] operation) {
        // 1. + - / * 가 나오면 스택에 집어 넣음
        // 3+4+5+6+7
        String result = new String();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < operation.length; i++) {
            // - 연산자가 나올 경우
            if (operation[i] == '+' || operation[i] == '-' || operation[i] == '*' || operation[i] == '/') {
                // op 스택에 push할건데 현재 스택 top에 있는 애가
                // 나와 똑같은 우선순위인지, 높은 우선순위인지 낮은 우선순위인지 판단해야함.
                if (operation[i] == '+' || operation[i] == '-') {
                    // 내가 +, - 이면 스택 꼭대기에는 나랑 똑같은 우선순위 혹은 나보다 높은 순위를 갖는 애밖에 없음
                    // peek을 pop하고, result 문자 추가 -> + 스택에 집어 넣기
                    while(!op.empty()) result += op.pop();
                    op.push(operation[i]);
                } else {
                    // 내가 *, /이면 스택 꼭대기에는 나랑 똑같은 우선순위 혹은 나보다 낮은 순위를 갖는 애가 있음
                    //System.out.println("op = "+operation[i]);
                    // 나랑 똑같은 우선순위의 경우 peek을 pop하고, result 문자 추가 -> + 스택에 집어 넣기
                    if(!op.empty()) {
                        if (op.peek() == '*' || op.peek() == '/') {
                            if(!op.empty()) result += op.pop();
                            op.push(operation[i]);
                        }
                        // peek에 나보다 낮은 우선순위가 있는 경우 그냥 push해줌
                        else if (op.peek() == '+' || op.peek() == '-') {
                            op.push(operation[i]);
                        }
                    }
                    //empty면 그냥 넣어
                    else {
                        op.push(operation[i]);
                    }
                }
            }
 
            // - 피연산자가 나올 경우 -> 그냥 result에 집어 넣으면 됨
            else {
                result += operation[i];
            }
        }//후위 연산자 다 만들어줌
         
        //but 스택에 있는 마지막 요소들 다 빼줘야함
        if(!op.empty()) {
            for(int i=0;i<op.size();i++) {
                result+=op.pop();
            }
        }
        return result;
    }
     
    public static int caluator(String last_change) {
        //34+5+6+7+ -> 배열로
        char[] last_arr = last_change.toCharArray();
 
        //이번에는 숫자를 스택에 넣어줄 것임
        Stack<Integer> num = new Stack<>();
         
        //연산자가 나오면 스택에 피연산자 2개를 pop해서 계산해줄 것임
        //계산 후 스택에 다시 넣을 것임
        //문자열 길이만큼 다 돌았다면 스택에 있는 수 1개를 꺼내 결과값을 보여줄 것
        for(int i=0;i<last_arr.length;i++) {
            //연산자가 나오면 숫자 스택에 있는 것 2개 pop -> 해당 연산자로 계산
            if(last_arr[i] == '+' || last_arr[i] == '-' || last_arr[i] == '*' || last_arr[i] == '/') {
                switch (last_arr[i]) {
                case '+':
                    int num1=num.pop();
                    int num2=num.pop();
                    num.push(num1+num2);                    
                    break;
                 
                case '-':
                    int num3=num.pop();
                    int num4=num.pop();
                    num.push(num3-num4);                    
                    break;
                     
                case '*':
                    int num5=num.pop();
                    int num6=num.pop();
                    num.push(num5*num6);                
                    break;
                     
                case '/':
                    int num7=num.pop();
                    int num8=num.pop();
                    num.push(num7/num8);                    
                    break;
                }
            }
             
            //숫자가 나오면 스택행
            else {
                num.push(last_arr[i]-'0');
            }
        }
         
        //계산완료 -> 스택에 있는 마지막 숫자 꺼내와서 전달.
        int result=0;
        while(!num.isEmpty()) {
            result+=num.pop();
        }
        return result;
    }
}