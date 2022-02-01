import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562 {//나이트의 이동
    private static int[][] map;
    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();
    private static Queue<int[]> q = new LinkedList<>();

    private static void bfs(int x, int y) {
        while(!q.isEmpty()){
            int n = q.peek()[0];
            int m = q.peek()[1];

            if(n == x && m == y){
                sb.append(map[n][m]).append("\n");
                break;
            }

            q.poll();

            for(int i = 0; i < 8; i++){
                int nx = n + dx[i];
                int ny = m + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < M && map[nx][ny] == 0){
                    map[nx][ny] = map[n][m] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            M = Integer.parseInt(br.readLine());
            map = new int[M][M];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            q.clear();
            q.add(new int[] {x,y});

            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            bfs(dx,dy);

        }

        System.out.println(sb.toString());
    }
}
