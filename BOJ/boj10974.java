import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10974 {//모든 순열
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static int N;

    public static void dfs(int len){
        if(len == N){
            for(int num : arr)
                sb.append(num).append(" ");
            sb.append("\n");
        }
       for(int i = 1; i <= N; i++){
           if(!visited[i]){
               visited[i] = true;
               arr[len] = i;
               dfs(len + 1);
               visited[i] = false;
           }
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N+1];

        dfs(0);

        System.out.println(sb.toString());
    }
}