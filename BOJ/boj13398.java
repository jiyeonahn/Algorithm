import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N+1];
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][2];
        dp[0][0] = num[0]; //삭제 하지 않은 경우
        dp[0][1] = num[0]; //삭제 한 경우
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(num[i], dp[i-1][0] + num[i]);
            dp[i][1] = Math.max(dp[i-1][1] + num[i], dp[i-1][0]); //이전 숫자를 제거하느냐, 현재 숫자를 제거하느냐
        }
        int max = -1000;
        for(int i = 0; i < N; i++){
            max = Math.max(Math.max(max, dp[i][0]), dp[i][1]);
        }

        System.out.println(max);
    }
}
