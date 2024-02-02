import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            Stack<Character> open = new Stack<>();
            boolean flag = true;
            String line = br.readLine();
            if(line.equals(".")) break;

            for(int i=0; i<line.length(); i++){
                char word = line.charAt(i);
                if(word == '[' || word == '('){//여는 괄호
                    open.add(word);
                }
                else if(word == ']' || word == ')'){//닫는 괄호
                    if(open.isEmpty()){//비었음
                        flag = false;
                        break;
                    }
                
                    char cur = open.pop();
                    if((word == ']' && cur != '[') || (word == ')' && cur != '(')){
                        flag = false;
                        break;
                    }
                    
                }
            }// for

            if(!flag) sb.append("no").append("\n");
            else{
                if(open.isEmpty()){
                    sb.append("yes").append("\n");
                }else{
                    sb.append("no").append("\n");
                }
            }
        }//while

        System.out.println(sb);
    }
}