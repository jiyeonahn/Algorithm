import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int current, int sum, int len) {
        if (len == N-1) {
            if (W[current][0] != 0) {
                answer = Math.min(answer, sum + W[current][0]);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (W[current][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, sum + W[current][i], len + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //출발지점 0으로 고정
        visited[0] = true;
        dfs(0, 0, 0);//현재지점, 합, 길이

        System.out.println(answer);
    }
}