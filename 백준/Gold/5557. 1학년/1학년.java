import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N-1][21]; //i번째까지 계산 했을 때 n을 만들 수 있는 경우의 수

        dp[0][arr[0]] = 1;

        for(int i = 1; i < N-1; i++){
            for(int j = 0; j <= 20; j++){
                if(j + arr[i] <= 20){
                    dp[i][j + arr[i]] += dp[i-1][j];
                }
                if(j - arr[i] >= 0){
                    dp[i][j - arr[i]] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-2][target]);
    }
}