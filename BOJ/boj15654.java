import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15654 {//N과 N(5)
    private static int[] arr, num;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;

    public static void dfs(int depth) {
        if (depth == M) {
            for (int n : arr)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = num[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        num = new int[N+1];
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0);
        System.out.println(sb.toString());
    }
}