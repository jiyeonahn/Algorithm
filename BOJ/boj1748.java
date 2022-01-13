import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int len = N.length();
        int n = 9;
        int n2 = 1;
        int answer = 0;

        for(int i = 1; i < len; i++){
            answer += i * n;
            n *= 10;
            n2 *= 10;
        }

        answer += (Integer.parseInt(N) - n2 + 1) * len;

        System.out.println(answer);
    }

}