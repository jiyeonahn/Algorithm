import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15650 {
    private static int[] arr;

    public static void dfs(int N, int M, int depth, int idx) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int n : arr)
                sb.append(n).append(" ");
            System.out.println(sb.toString());
            return;
        }
        for (int i = idx; i <= N; i++) {
            arr[depth] = i;
            dfs(N, M, depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 0, 1);

    }
}