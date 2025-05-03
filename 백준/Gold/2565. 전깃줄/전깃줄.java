import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            pq.add(new int[]{A,B});
        }

        int[] arr = new int[N];
        int idx = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            arr[idx++] = cur[1];
        }

        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            if(dp[i] == 0) dp[i] = 1;
            for(int j = i+1; j < N; j++){
                if(arr[j] > arr[i]){
                    dp[j] = Math.max(dp[j],dp[i]+1);
                }
            }
        }

        int lis = 0;
        for(int d : dp){
            lis = Math.max(lis, d);
        }

        System.out.println(N-lis);
    }
}