import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10819 {//차이를 최대로
    private static int[] arr, num;
    private static boolean[] visited;
    private static int N, max, sum;

    public static void dfs(int len){
        if(len == N){
            sum = 0;
            for(int i = 1; i < N; i++){
                sum += Math.abs(arr[i-1] - arr[i]);
            }
            max = Math.max(max, sum);
        }

       for(int i = 0; i < N; i++){
           if(!visited[i]){
               visited[i] = true;
               arr[len] = num[i];
               dfs(len + 1);
               visited[i] = false;
           }
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        num = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0);

        System.out.println(max);
    }
}