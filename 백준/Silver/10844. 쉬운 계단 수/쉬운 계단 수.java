import java.io.*;
class Main{
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][1] % MOD; //0은 1뒤에만 올 수 있다.
                }else if(j == 9){
                    dp[i][j] = dp[i-1][8] % MOD;//9는 8뒤에만 올 수 있다.
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
                }
            }
        }
        long answer = 0;
        for(int n : dp[N]){
            answer += n % MOD;
        }
        System.out.println(answer % MOD);
    }
}