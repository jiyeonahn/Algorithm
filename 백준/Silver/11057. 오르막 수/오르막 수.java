import java.io.*;
class Main{
    static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = j; k <= 9; k++){
                    dp[i][j] += dp[i-1][k] % MOD;
                }
            }
        }
        int answer = 0;
        for(int n : dp[N]){
            answer += n;
        }
        System.out.println(answer % MOD);
    }
}