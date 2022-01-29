import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {//미로탐색
    private static int N, M;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited;

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                    map[nx][ny] = map[x][y] + 1;
                }
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

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs();

        System.out.println(map[N-1][M-1]);
    }

}