import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] dp2 = new int[N];

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(seq[i] > seq[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for(int i = N-1; i >= 0; i--){
            dp2[i] = 0;
            for(int j = N-1; j > i; j--){
                if(seq[i] > seq[j]){
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i] + dp2[i]);
        }
        System.out.println(max);
    }
}