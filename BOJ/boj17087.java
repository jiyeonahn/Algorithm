import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int temp = Math.abs(Integer.parseInt(st.nextToken()) - S);
        for(int i = 1; i < N; i++)
        {
            int num = gcd(temp, Math.abs(Integer.parseInt(st.nextToken()) - S));
            temp = num;
        }

        System.out.println(temp);
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
