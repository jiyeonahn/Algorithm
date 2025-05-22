import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        int[][] dp2 = new int[N][3];
        dp2[0][0] = arr[0][0];
        dp2[0][1] = arr[0][1];
        dp2[0][2] = arr[0][2];

        for(int i = 1; i < N; i++){
            dp[i][0] = arr[i][0] + Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = arr[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][2] = arr[i][2] + Math.max(dp[i-1][1], dp[i-1][2]);

            dp2[i][0] = arr[i][0] + Math.min(dp2[i-1][0], dp2[i-1][1]);
            dp2[i][1] = arr[i][1] + Math.min(dp2[i-1][0], Math.min(dp2[i-1][1], dp2[i-1][2]));
            dp2[i][2] = arr[i][2] + Math.min(dp2[i-1][1], dp2[i-1][2]);
        }

        int max = Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));
        int min = Math.min(dp2[N-1][0], Math.min(dp2[N-1][1], dp2[N-1][2]));

        System.out.println(max + " " + min);
    }
}