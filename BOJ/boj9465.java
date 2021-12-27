import java.io.*;
import java.util.StringTokenizer;

public class boj9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[1][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int j = 2; j <= n; j++){
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }
            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}