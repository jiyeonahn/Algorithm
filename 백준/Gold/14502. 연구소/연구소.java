import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {//연구소
    private static int N, M, max;
    private static int[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth){
        if(depth == 3){
            bfs();
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        Queue<int []> queue = new LinkedList<>();
        int[][] virusMap = new int[N][M];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            if (M >= 0) System.arraycopy(map[i], 0, virusMap[i], 0, M);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(virusMap[i][j] == 2){
                    queue.add(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int n = queue.peek()[0];
            int m = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int next_n = n + dx[i];
                int next_m = m + dy[i];

                if(next_n >= 0 && next_n < N && next_m >= 0 && next_m < M && virusMap[next_n][next_m] == 0){
                    virusMap[next_n][next_m] = 2;
                    queue.add(new int[] {next_n,next_m});
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(virusMap[i][j] == 0)
                    cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
}