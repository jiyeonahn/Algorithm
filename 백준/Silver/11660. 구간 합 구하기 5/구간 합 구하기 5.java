import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < N; i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int condition = 0;
            if(y1 > 0){
                condition += dp[x2][y1 - 1];
            }
            if(x1 > 0){
                condition += dp[x1 - 1][y2];
            }
            if(x1 > 0 && y1 > 0){
                condition -= dp[x1 - 1][y1 - 1];
            }

            sum = dp[x2][y2] - (condition);

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}