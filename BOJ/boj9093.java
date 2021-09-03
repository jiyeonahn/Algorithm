import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb;

        int N  = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            sb = new StringBuffer();
            String str = br.readLine() + "\n";
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == ' ' || str.charAt(j) == '\n'){
                    while(!stack.empty()){
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }
                else
                    stack.push(str.charAt(j));
            }
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
