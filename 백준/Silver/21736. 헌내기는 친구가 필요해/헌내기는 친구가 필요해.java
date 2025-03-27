import java.util.*;
import java.io.*;

class Main {
    static int answer;
    static char[][] campus;
    static int N, M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (campus[i][j] == 'I') {
                    visited[i][j] = true;
                    dfs(i, j);
                    break;
                }
            }
        }
        System.out.println(answer == 0 ? "TT" : answer);
    }

    public static void dfs(int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int dx_x = x + dx[i];
            int dy_y = y + dy[i];

            if (dx_x >= 0 && dx_x < N && dy_y >= 0 && dy_y < M) {
                if (!visited[dx_x][dy_y] && campus[dx_x][dy_y] != 'X') {
                    visited[dx_x][dy_y] = true;
                    if (campus[dx_x][dy_y] == 'P') {
                        answer++;
                    }
                    dfs(dx_x, dy_y);

                }
            }
        }
    }
}