import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1987 {//알파벳
    private static int R, C, answer = 1;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] map;
    private static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int n, int m, int count) {
        if(visited[map[n][m]]) {
            answer = Math.max(count, answer);
        }
        else{
            visited[map[n][m]] = true;
            for (int i = 0; i < 4; i++) {
                int N = n + dx[i];
                int M = m + dy[i];

                if (N >= 0 && N < R && M >= 0 && M < C) {
                    dfs(N, M, count + 1);
                }
            }
            visited[map[n][m]] = false;
        }
    }
}