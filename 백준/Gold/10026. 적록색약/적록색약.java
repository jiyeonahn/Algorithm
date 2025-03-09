import java.util.*;
import java.io.*;

class Main {
    static int N;
    static char[][] picture;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                picture[i][j] = str.charAt(j);
            }
        }
        int color = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    color++;
                    dfs(i, j, picture[i][j]);
                }
            }
        }

        visited = new boolean[N][N];
        int color_blindness = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                if(picture[i][j] == 'G'){
                    picture[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    color_blindness++;
                    dfs(i, j, picture[i][j]);
                }
            }
        }

        System.out.println(color + " " + color_blindness);
    }

    public static void dfs(int x, int y, char ch) {
        for (int i = 0; i < 4; i++) {
            int dx_x = x + dx[i];
            int dy_y = y + dy[i];

            if (dx_x >= 0 && dx_x < N && dy_y >= 0 && dy_y < N) {
                if (!visited[dx_x][dy_y] && picture[dx_x][dy_y] == ch) {
                    visited[dx_x][dy_y] = true;
                    dfs(dx_x, dy_y, ch);
                }
            }
        }
    }

}