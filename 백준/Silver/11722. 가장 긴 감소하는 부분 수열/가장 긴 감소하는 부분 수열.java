import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(arr[j] < arr[i]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }

        int max = 0;
        for(int d : dp){
            max = Math.max(max, d);
        }

        System.out.println(max);
    }
}