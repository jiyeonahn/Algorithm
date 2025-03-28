import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        StringBuilder answer = new StringBuilder();
        StringBuilder sb;
        while((n = Integer.parseInt(br.readLine())) != 0){
            sb = new StringBuilder();
            sb.append(n);
            if(n==Integer.parseInt(sb.reverse().toString())){
                answer.append("yes");
            }else{
                answer.append("no");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}