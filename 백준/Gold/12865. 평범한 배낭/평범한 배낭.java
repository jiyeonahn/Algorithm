import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //물품 수
        int K = Integer.parseInt(st.nextToken()); //최대 무게

        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            //현재 물건
            int W = Integer.parseInt(st.nextToken());//무게
            int V = Integer.parseInt(st.nextToken());//가치

            for(int j = 0 ; j <= K; j++){//j무게의 배낭
                if(j < W){//배낭에 넣을 수 있는 최대 무게 보다 물건의 무게가 클 때 => 배낭에 물건을 넣을 수 없음
                    dp[i][j] = dp[i-1][j];
                }else{//배낭에 넣을 수 있는 최대 무게 보다 물건의 무게가 작거나 같을 때 => 배낭에 물건을 넣을 수 있음
                    dp[i][j] = Math.max(dp[i-1][j], V + dp[i-1][j-W]);
                }
            }

        }
        System.out.println(dp[N][K]);
    }
}