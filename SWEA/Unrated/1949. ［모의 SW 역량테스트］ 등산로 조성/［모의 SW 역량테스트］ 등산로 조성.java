import java.util.*;
import java.io.*;

class Solution {
    static int cnt;
    static int answer;
    static int[][] arr;
    static int N, K;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            int max = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(arr[i][j], max);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == max) {
                        visited = new boolean[N][N];
                        visited[i][j] = true;
                        cnt = 0;
                        dfs(i, j, 1);
                        visited[i][j] = false;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y, int len) {
        answer = Math.max(answer, len);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny]) {
                    if (arr[nx][ny] < arr[x][y]) {
                        visited[nx][ny] = true;
                        dfs(nx, ny, len + 1);
                        visited[nx][ny] = false;
                    } else if (cnt == 0) {
                        for (int j = 1; j <= K; j++) {
                           if (arr[nx][ny] - j < 0) {
                                break;
                            }
                            if (arr[nx][ny] - j < arr[x][y]) {
                                visited[nx][ny] = true;
                                cnt = 1;
                                arr[nx][ny] -= j;
                                dfs(nx, ny, len + 1);
                                visited[nx][ny] = false;
                                cnt = 0;
                                arr[nx][ny] += j;
                            }
                        }

                    }
                }
            }
        }
    }
}