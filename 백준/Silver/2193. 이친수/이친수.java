import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][2];
        dp[1][1] = 1;

        for(int i = 2; i <= N; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        long answer = 0;
        for(long n : dp[N]){
            answer += n;
        }
        System.out.println(answer);
    }
}