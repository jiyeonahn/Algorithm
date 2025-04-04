import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        visited = new boolean[N];
        sequence = new int[M];
        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int idx) {
        if (idx == M) {
            for (int s : sequence) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && before != arr[i]) {
                visited[i] = true;
                before = arr[i];
                sequence[idx] = arr[i];
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }
}