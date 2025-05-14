import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N+1];

        for(int i = 1; i <= N; i++){
            sum[i] = arr[i] + sum[i-1];
        }

        int max = -10000000;
        for(int i = 1; i <= N-K+1; i++){
            int start = i;
            int end = i+K-1;

            max = Math.max(max, sum[end] - sum[start-1]);
        }

        System.out.println(max);
    }
}