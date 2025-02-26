import java.util.*;
import java.io.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    static int number = 1;
    static int N;
    static int[][] island;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        island = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬을 구분하고 해안선 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && island[i][j] == 1) {
                    number++;
                    visited[i][j] = true;
                    island[i][j] = number;
                    dfs(i, j);
                }
            }
        }

        // 2. 각 섬의 해안선에서 BFS 수행하여 최단 거리 찾기
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            int distance = bfs(x, y, island[x][y]);
            answer = Math.min(answer, distance);

            if (answer == 1) break;  // ✅ 최소 다리 길이가 1이면 종료
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (island[nx][ny] == 0) {  // ✅ 해안선이면 큐에 추가
                    queue.add(new int[]{x, y});
                } else if (!visited[nx][ny] && island[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    island[nx][ny] = number;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static int bfs(int x, int y, int current_island) {
        Queue<int[]> queue1 = new LinkedList<>();
        queue1.add(new int[]{x, y});
        boolean[][] visited2 = new boolean[N][N];
        visited2[x][y] = true;
        int count = 0;

        while (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue1.poll();
                int xx = current[0];
                int yy = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = xx + dx[d];
                    int ny = yy + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (!visited2[nx][ny]) {
                            visited2[nx][ny] = true;
                            if (island[nx][ny] == 0) {
                                queue1.add(new int[]{nx, ny});
                            } else if (island[nx][ny] != current_island) {
                                return count;  // ✅ 다른 섬 도착 시 반환
                            }
                        }
                    }
                }
            }
            count++;  // ✅ 거리 증가
        }
        return count;
    }
}
