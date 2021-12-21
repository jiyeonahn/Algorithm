import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N+1];
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = num[0];
        for(int i = 1; i < N; i++){
            dp[i] = Math.max(num[i], dp[i-1] + num[i]);
        }
        int max = IntStream.of(dp).max().orElse(0);

        System.out.println(max);
    }
}
