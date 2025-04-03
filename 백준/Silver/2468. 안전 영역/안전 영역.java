import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int h = 0;
        int max = 0;
        int count = 1;
        while (count != 0) {
            h++;
            count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] >= h && !visited[i][j]) {//안전한 영역
                        visited[i][j] = true;
                        count++;
                        dfs(i, j, h);
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y, int h) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && arr[nx][ny] >= h) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, h);
                }
            }
        }
    }
}