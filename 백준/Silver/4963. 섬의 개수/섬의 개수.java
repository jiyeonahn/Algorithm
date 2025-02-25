import java.util.*;
import java.io.*;
class Main{
    static int w, h;
    static boolean[][] visited;
    static int[][] landSeaMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            landSeaMap = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    landSeaMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(landSeaMap[i][j] == 1 && !visited[i][j]){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        int[] dx = {1,0,-1,0,1,1,-1,-1};
        int[] dy = {0,1,0,-1,1,-1,1,-1};
        for(int i = 0; i < 8; i++){
            int dx_x = x+dx[i];
            int dy_y = y+dy[i];

            if(dx_x >= 0 && dx_x < h && dy_y >=0 && dy_y < w){
                if(landSeaMap[dx_x][dy_y] == 1 && !visited[dx_x][dy_y]){
                    dfs(dx_x,dy_y);
                }
            }
        }
    }
}