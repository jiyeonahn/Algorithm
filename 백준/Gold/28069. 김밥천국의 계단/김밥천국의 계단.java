import java.util.*;
import java.io.*;

class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (i + 1 <= N) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            if (i + i / 2 <= N) {
                dp[i + i / 2] = Math.min(dp[i + i / 2], dp[i] + 1);
            }
        }

        //System.out.println(dp[N]);
        System.out.println(dp[N] <= K ? "minigimbob" : "water");

    }
}