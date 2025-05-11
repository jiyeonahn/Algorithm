import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 1;
        if(N >= 2){
            dp[2] = 2;
        }
        if(N >= 3){
            dp[3] = 3;
        }

        for(int i = 4; i <= N; i++){
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }

        System.out.println(dp[N]);
    }
}