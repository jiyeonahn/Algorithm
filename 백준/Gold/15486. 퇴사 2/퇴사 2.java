import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+2][2];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());//T
            arr[i][1] = Integer.parseInt(st.nextToken());//P
        }

        int[] dp = new int[N+2];

        int max = 0;

        for(int i = 1; i <= N+1; i++){
            max = Math.max(dp[i], max);//i까지 왔을 때 최대보상

            int nextT = i + arr[i][0];
            if(nextT < N + 2) {
                dp[nextT] = Math.max(dp[nextT], max + arr[i][1]);
            }
        }

        System.out.println(max);
    }
}