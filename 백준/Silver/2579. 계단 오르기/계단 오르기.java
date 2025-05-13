import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];

        if(n == 1){
            System.out.println(arr[0]);
            return;
        }

        dp[n-1] = arr[n-1];

        if(n >= 2){
            dp[n-2] = arr[n-2] + arr[n-1];
        }
        if(n >= 3){
            dp[n-3] = arr[n-3] + arr[n-1];
        }
        for(int i = n-4; i >= 0; i--){
            dp[i] = arr[i] + Math.max(dp[i+2], arr[i+1] + dp[i+3]);
        }

        System.out.println(Math.max(dp[0], dp[1]));
    }
}