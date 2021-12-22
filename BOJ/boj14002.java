import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] seq = new int[N];
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

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
        Stack<Integer> stack = new Stack<>();

        for(int i = N-1; i >= 0; i--){
            if(dp[i] == max){
                stack.push(seq[i]);
                max--;
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
