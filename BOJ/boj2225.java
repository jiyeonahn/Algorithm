import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[201][201];

        for(int i = 0; i <= N; i++){
            dp[i][1] = 1;
            dp[i][2] = i+1;
        }

        for(int k = 3; k <= K; k++){
            for(int i = 0; i <= N; i++){
                for(int j = i; j >= 0; j--){
                    dp[i][k] += dp[j][k-1] % 1000000000;
                }
            }
        }

        System.out.println(dp[N][K] % 1000000000);
    }
}
