import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int max = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int low = max;
        int high = sum;
        int result = 0;

        while(low <= high){
            int mid = (low + high) / 2;

            int key = 0;
            int cnt = 1;

            for(int i = 0; i < N - 1; i++){
                key += arr[i];
                if(mid < key + arr[i+1]){
                    cnt++;
                    key = 0;
                }
            }
            if(cnt <=  M){
                high = mid - 1;
                result = mid;
            }else{
                low = mid + 1;
            }
        }
        System.out.println(result);
    }
}