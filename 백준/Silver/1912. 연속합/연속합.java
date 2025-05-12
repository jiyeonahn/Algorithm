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
        dp[0] = arr[0];
        int max = -1000;
        for(int i = 1; i < N; i++){
            if(dp[i-1]+arr[i] > arr[i]){
                dp[i] = dp[i-1]+arr[i];
            }else{
                dp[i] = arr[i];
            }
        }

        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}