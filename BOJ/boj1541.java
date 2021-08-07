import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minus = new StringTokenizer(br.readLine(),"-");

        int answer = 999999;

        while(minus.hasMoreTokens()){
           int sum = 0;
            StringTokenizer plus = new StringTokenizer(minus.nextToken(),"+");
            while(plus.hasMoreTokens()) {
                sum += Integer.parseInt(plus.nextToken());
            }
            if (answer == 999999) answer = sum;
            else answer -= sum;
        }
        System.out.println(answer);

    }
}