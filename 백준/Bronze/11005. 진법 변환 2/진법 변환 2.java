import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            if(N%B >= 10){
                sb.append((char)(N%B+55));
            }else{
                sb.append(N%B);
            }
            N = N/B;
        }
        System.out.println(sb.reverse().toString());
    }
}