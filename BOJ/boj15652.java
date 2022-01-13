import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15652 {//N과 M(4)
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;

    public static void dfs(int depth, int idx) {
        if (depth == M) {
            for (int n : arr)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = idx; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0,1);
        System.out.println(sb.toString());
    }
}