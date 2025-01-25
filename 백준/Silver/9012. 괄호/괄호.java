import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            Stack<String> stack = new Stack<>();
            String str = br.readLine();
            char[] arr = str.toCharArray();
            for (char c : arr) {
                if (c == ')') {
                    if (!stack.isEmpty() && "(".equals(stack.peek())) {
                        stack.pop();
                    }else{
                        stack.push(String.valueOf(c));
                    }
                } else {
                    stack.push(String.valueOf(c));
                }
            }
            if(stack.isEmpty()){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}