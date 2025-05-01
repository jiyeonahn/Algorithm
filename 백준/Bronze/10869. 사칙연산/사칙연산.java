import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int sum = A+B;
        int minus = A-B;
        int mul = A*B;
        int sub = A/B;
        int num = A%B;

        StringBuilder sb = new StringBuilder();
        sb.append(sum)
                .append("\n")
                .append(minus)
                .append("\n")
                .append(mul)
                .append("\n")
                .append(sub)
                .append("\n")
                .append(num);

        System.out.println(sb);

    }
}