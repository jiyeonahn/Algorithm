import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] seq = new int[N+1];
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int k = 0; k < i; k++){
                if(seq[i] > seq[k]){
                    dp[i] = Math.max(dp[k] + 1, dp[i]);
                }
            }
        }

        int max = IntStream.of(dp).max().orElse(0);
        System.out.println(max);
    }
}
