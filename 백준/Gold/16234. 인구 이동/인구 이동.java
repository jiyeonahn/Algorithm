import java.util.*;
import java.io.*;

class Main {
    static int sum;
    static int N, L, R;
    static int[][] A;
    static ArrayList<int[]> list;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean conti = true;
        int answer = -1;

        while (conti) {
            answer++;
            conti = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        list = new ArrayList<>();
                        list.add(new int[]{i, j});
                        sum = A[i][j];
                        dfs(i, j);
                        int size = list.size();
                        if (size > 1) {
                            conti = true;
                            int newValue = sum / size;
                            for (int[] location : list) {
                                int newX = location[0];
                                int newY = location[1];

                                A[newX][newY] = newValue;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && Math.abs(A[x][y] - A[nx][ny]) >= L && Math.abs(A[x][y] - A[nx][ny]) <= R) {
                    visited[nx][ny] = true;
                    list.add(new int[]{nx, ny});
                    sum += A[nx][ny];
                    dfs(nx, ny);
                }
            }
        }

    }
}