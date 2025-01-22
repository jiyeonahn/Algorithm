import java.io.*;
import java.util.PriorityQueue;

class Main{
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int total = 0;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] > 0){
                    count = 1;
                    map[i][j] = 0;
                    total++;
                    dfs(map, i, j, N);
                    pq.add(count);
                }
            }
        }
        sb.append(total);
        while(!pq.isEmpty()){
            sb.append("\n").append(pq.poll());
        }
        System.out.println(sb);
    }
    public static void dfs(int[][] map, int x, int y, int N){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int i = 0; i < 4; i++){
            int dx_x = x + dx[i];
            int dy_y = y + dy[i];

            if(dx_x >= 0 && dx_x < N && dy_y >= 0 && dy_y < N){
                if(map[dx_x][dy_y] > 0){
                    count++;
                    map[dx_x][dy_y] = 0;
                    dfs(map, dx_x, dy_y, N);
                }
            }
        }
    }
}