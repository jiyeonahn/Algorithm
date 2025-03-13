import java.io.*;
import java.util.*;

class Main {
    static int up, down, R, C;
    static int[][] next, current;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] dust = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                dust[i][j] = Integer.parseInt(st.nextToken());
                if (dust[i][j] == -1) {
                    if (up > 0) {
                        down = i;
                        continue;
                    }
                    up = i;
                }
            }
        }

        current = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                current[i][j] = dust[i][j];
            }
        }

        while (T > 0) {
            next = new int[R][C];
            T--;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (current[i][j] > 0) {
                        diffusion(i, j, current[i][j]);
                    }
                }
            }

            airPurification();

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    current[i][j] = next[i][j];
                }
            }
            current[up][0] = -1;
            current[down][0] = -1;
        }
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += next[i][j];
            }
        }
        System.out.println(answer);
    }

    public static void airPurification() {
        int temp[][] = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = next[i][j];
            }
        }
        //위쪽 순환
        next[up][1] = 0;
        for (int j = 2; j <= C - 1; j++) {
            next[up][j] = temp[up][j - 1];
        }
        for (int i = 0; i <= up - 1; i++) {
            next[i][C - 1] = temp[i + 1][C - 1];
        }
        for (int j = 0; j < C - 1; j++) {
            next[0][j] = temp[0][j + 1];
        }
        for (int i = up - 1; i >= 1; i--) {
            next[i][0] = temp[i - 1][0];
        }
        //아래쪽 순환
        next[down][1] = 0;
        for (int j = 2; j <= C - 1; j++) {
            next[down][j] = temp[down][j - 1];
        }
        for (int i = down + 1; i <= R - 1; i++) {
            next[i][C - 1] = temp[i - 1][C - 1];
        }
        for (int j = 0; j < C - 1; j++) {
            next[R - 1][j] = temp[R - 1][j + 1];
        }
        for (int i = down + 1; i < R - 1; i++) {
            next[i][0] = temp[i + 1][0];
        }
    }

    public static void diffusion(int x, int y, int n) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int dx_x = x + dx[i];
            int dy_y = y + dy[i];

            if (dx_x >= 0 && dx_x < R && dy_y >= 0 && dy_y < C && current[dx_x][dy_y] != -1) {
                count++;
                next[dx_x][dy_y] += n / 5;
            }
        }
        next[x][y] = next[x][y] + (n - n / 5 * count);
    }
}