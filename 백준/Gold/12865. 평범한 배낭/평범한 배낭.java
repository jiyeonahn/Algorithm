import com.sun.security.jgss.GSSUtil;
import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        //dp: i번째 배낭까지 넣을 수 있으면서 배낭 무게 j이하일 때의 최대 가치

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for(int j = 0; j <= K; j++){
                if(W > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], V+dp[i-1][j-W]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}