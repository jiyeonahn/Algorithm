import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15649 {
    private static boolean[] visited;
    private static int[] arr;

    public static void dfs(int N, int M, int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int n : arr)
                sb.append(n).append(" ");
            System.out.println(sb.toString());
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(N, M, depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];

        dfs(N, M, 0);

    }
}