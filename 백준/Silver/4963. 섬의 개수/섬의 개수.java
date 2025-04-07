import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int w, h, count;
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        visited[i][j] = true;
                        dfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}