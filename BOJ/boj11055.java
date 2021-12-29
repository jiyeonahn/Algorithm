import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            dp[i] = seq[i];
            for(int j = 0; j < i; j++){
                if(seq[i] > seq[j]){
                    dp[i] = Math.max(dp[i], dp[j] + seq[i]);
                }
            }
        }

        int max = IntStream.of(dp).max().orElse(0);
        System.out.println(max);
    }
}