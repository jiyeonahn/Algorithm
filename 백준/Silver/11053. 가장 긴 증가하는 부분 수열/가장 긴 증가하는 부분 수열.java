import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = 0;
        for(int n : dp){
            max = Math.max(n, max);
        }
        System.out.println(max);
    }
}