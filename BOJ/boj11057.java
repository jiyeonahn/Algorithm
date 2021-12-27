import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int n = 2; n <= N; n++){
            for(int i = 0; i < 10; i++){
                for(int j = i; j < 10; j++){
                    dp[n][i] += (dp[n-1][j] % 10007);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i <= 9; i++){
            answer += dp[N][i];
        }

        System.out.println(answer % 10007);
    }
}