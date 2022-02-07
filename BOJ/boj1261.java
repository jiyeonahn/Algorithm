import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class boj1261 {
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    private static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        ans = new int[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(ans[M - 1][N - 1]);
    }

    public static void bfs() {
        boolean[][] visited = new boolean[M][N];
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int m = q.peek()[0];
            int n = q.peek()[1];
            q.poll();

            if (m == M - 1 && n == N - 1) return;

            for (int i = 0; i < 4; i++) {
                int next_m = m + dx[i];
                int next_n = n + dy[i];

                if (next_m >= 0 && next_m < M && next_n >= 0 && next_n < N && !visited[next_m][next_n]) {
                    if (map[next_m][next_n] == 1)
                        ans[next_m][next_n] = ans[m][n] + 1;
                    else
                        ans[next_m][next_n] = ans[m][n];

                    q.add(new int[]{next_m, next_n, ans[next_m][next_n]});
                    visited[next_m][next_n] = true;
                }
            }
        }
    }
}
