import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4963 {//섬의 개수
    private static int h, w;
    private static int[] dx = {1, 0, 0, -1, -1, 1, 1, -1};
    private static int[] dy = {0, 1, -1, 0, -1, -1, 1, 1};
    private static int[][] map;
    private static boolean[][] visited;

    public static void dfs(int i, int j){
        visited[i][j] = true;

        for(int k = 0; k < 8; k++){
            int H = i + dx[k];
            int W = j + dy[k];

            if(H >= 0 && H < h && W >= 0 && W < w && !visited[H][W] && map[i][j] == 1){
                visited[H][W] = true;
                dfs(H,W);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        answer++;
                        dfs(i,j);
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

}