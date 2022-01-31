import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16929 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int N, M, start_i, start_j;

    private static void dfs(int i, int j, int cnt) {

        for(int next = 0; next < 4; next++){
            int nx = i + dx[next];
            int ny = j + dy[next];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == map[start_i][start_j] && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1);
                visited[nx][ny] = false;
            }
            else if(cnt >= 4 && nx == start_i && ny == start_j){//최소 4개는 돌아야하니까
                System.out.println("Yes");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j)-'A';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    start_i = i;
                    start_j = j;
                    visited[i][j] = true;
                    dfs(i, j, 1);
                }
            }
        }

        System.out.println("No");
    }
}
