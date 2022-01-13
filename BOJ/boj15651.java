import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15651 {//N과 M(3)
    private static int[] arr;
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
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0);
        System.out.println(sb.toString());
    }
}