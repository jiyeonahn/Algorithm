import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long max = 0;

        for(int num : arr){
            max = Math.max(num, max);
        }

        long low = 1;
        long high = max;
        long result = 0;

        while(low <= high){
            long mid = (low + high) / 2;

            long count = 0;

            for(int i = 0; i < K; i++){
                count += arr[i] / mid;
            }

            if(count >= N){
                result = mid;
                low = mid + 1;//랜선의 최대 길이를 찾아야하므로
            }else{
                high = mid - 1;
            }
        }
        System.out.println(result);
    }
}