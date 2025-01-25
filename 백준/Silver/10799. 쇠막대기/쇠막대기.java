import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();
        Stack<String> stack = new Stack<>();
        int answer = 0;
        char before = 0;
        for(char ch : arr){
            if(ch == '('){
                stack.push(String.valueOf(ch));
            }else{ //')'
                stack.pop();
                if(before == ')'){ //막대기가 끝나는 지점
                    answer++;
                }else{  //레이저
                    answer += stack.size();
                }
            }
            before = ch;
        }
        System.out.println(answer);
    }
}