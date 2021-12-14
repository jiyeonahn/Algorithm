import java.io.*;

public class boj15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][4];
        long answer;

        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for(int i = 4; i <= 100000; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
        }

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            answer = (dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009;
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}