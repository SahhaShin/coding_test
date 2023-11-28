import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int T = 1; T<=t; T++){
            String password = br.readLine();

            Stack<Character> stack = new Stack<>();
            Stack<Character> pop_store = new Stack();

            for(int i=0;i<password.length();i++){

                char command = password.charAt(i);

                if(command == '<' || command == '-'){//pop
                    if(stack.isEmpty()) continue;
                    else if(command == '-') stack.pop();
                    else pop_store.push(stack.pop());
                }

                else if(command == '>'){ //push
                    if(pop_store.isEmpty())continue;
                    else stack.push(pop_store.pop());
                }

                else{ //그냥 문자
                    stack.push(command);
                }
            }
            
            while (pop_store.size()>0) {
                stack.push(pop_store.pop());
            }

            StringBuilder sb = new StringBuilder();
            int stack_size = stack.size();
            for(int i=0;i<stack_size;i++){
                sb.append(stack.pop());
            }

            System.out.println(sb.reverse());
        }//test case end
    }
}