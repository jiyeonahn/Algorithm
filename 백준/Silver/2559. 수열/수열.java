import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = K;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while(right<= N){
            sum = 0;
            for(int i = left; i < right; i++){
                sum += arr[i];
            }
            max = Math.max(max, sum);
            left++;
            right = left+K;
        }

        System.out.println(max);
    }
}