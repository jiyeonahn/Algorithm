import java.util.*;
import java.io.*;
class Main{
    static boolean[][] visited;
    static int N;
    static int M;
    static int[][] iceberg;
    static int[][] temp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        iceberg = new int[N][M];
        temp = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                iceberg[i][j] = Integer.parseInt(st.nextToken());
                temp[i][j] = iceberg[i][j];
            }
        }

        int answer = 0;

        if(countOfChunk() == 1){ //빙산이 이미 분리된 경우는 검사하지 않음
            while(true){
                for(int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (iceberg[i][j] > 0) {
                            melting(i, j);
                        }
                    }
                }
                for(int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        iceberg[i][j] = temp[i][j];
                    }
                }
                answer++;
                if(countOfChunk() == 0){ //빙산이 다 녹음
                    answer = 0;
                    break;
                }
                if(countOfChunk() > 1){ //빙산이 분리됨
                    break;
                }
            }
        }
        System.out.println(answer);
    }
    public static void melting(int x, int y){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int cnt = 0;

        for(int i = 0; i < 4; i++) {
            int dx_x = x + dx[i];
            int dy_y = y + dy[i];

            if(dx_x >= 0 && dx_x < N && dy_y >= 0 && dy_y < M){
                if(iceberg[dx_x][dy_y] == 0){
                    cnt++;
                }
            }
        }
        temp[x][y] = Math.max(iceberg[x][y] - cnt, 0);
    }
    public static void dfs(int x, int y){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int dx_x = x + dx[i];
            int dy_y = y + dy[i];

            if(dx_x >= 0 && dx_x < N && dy_y >= 0 && dy_y < M){
                if(!visited[dx_x][dy_y] && iceberg[dx_x][dy_y] > 0){
                    dfs(dx_x, dy_y);
                }
            }
        }
    }
    public static int countOfChunk(){
        visited = new boolean[N][M];
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && iceberg[i][j] > 0){
                    count++;
                    dfs(i,j);
                }
            }
        }
        return count;
    }
}