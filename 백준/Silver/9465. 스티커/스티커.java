import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                sticker[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                sticker[1][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            if(n > 1){
                dp[0][1] = sticker[0][1] + dp[1][0];
                dp[1][1] = sticker[1][1] + dp[0][0];
                for(int j = 2; j < n; j++){
                    dp[0][j] = sticker[0][j] + Math.max(dp[1][j-1], dp[1][j-2]);
                    dp[1][j] = sticker[1][j] + Math.max(dp[0][j-1], dp[0][j-2]);
                }
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}