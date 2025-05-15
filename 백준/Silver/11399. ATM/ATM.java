import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] sum = new int[N];
        sum[0] = arr[0];
        for(int i = 1; i < N; i++){
            sum[i] = arr[i] + sum[i-1];
        }

        int total = 0;
        for(int s : sum){
            total += s;
        }

        System.out.println(total);
    }
}