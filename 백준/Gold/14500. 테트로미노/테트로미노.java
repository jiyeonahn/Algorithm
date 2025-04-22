import java.util.*;
import java.io.*;

class Main {
    static int max;
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1,  arr[i][j]);
                visited[i][j] = false;
                check(i,j);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int x, int y, int len, int sum) {
        if(len == 4){
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, len+1, sum + arr[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void check(int x, int y){
        if(x-1 >= 0 && x+1 < N && y+1 < M){
            max = Math.max(max, arr[x][y]+arr[x-1][y]+arr[x+1][y]+arr[x][y+1]);
        }

        if(x-1 >= 0 && x+1 < N && y-1 >= 0){
            max = Math.max(max, arr[x][y]+arr[x-1][y]+arr[x+1][y]+arr[x][y-1]);
        }

        if(y-1 >= 0 && y+1 < M && x-1 >= 0){
            max = Math.max(max, arr[x][y]+arr[x][y-1]+arr[x][y+1]+arr[x-1][y]);
        }

        if(y-1 >= 0 && y+1 < M && x+1 < N){
            max = Math.max(max, arr[x][y]+arr[x][y-1]+arr[x][y+1]+arr[x+1][y]);
        }
    }
}

