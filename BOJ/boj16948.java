import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16948 {
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int N, r1, c1, r2, c2, answer = -1;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs(r1, c1);
        System.out.println(answer);
    }

    private static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});

        while(!queue.isEmpty()){
            int r1 = queue.peek()[0];
            int c1 = queue.peek()[1];
            queue.poll();

            if(r1 == r2 && c1 == c2){
                answer = map[r1][c1];
                break;
            }

            for(int i = 0; i < 6; i++){
                int nr = r1 + dx[i];
                int nc = c1 + dy[i];

                if(nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == 0){
                    map[nr][nc] = map[r1][c1] + 1;
                    queue.add(new int[] {nr, nc});
                }
            }
        }
    }

}