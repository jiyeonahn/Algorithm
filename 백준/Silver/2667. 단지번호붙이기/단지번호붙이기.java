import java.io.*;
import java.util.*;

class Main{
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, homeInComplex;
    static ArrayList<Integer> home = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        int complex = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    homeInComplex = 0;
                    complex++;
                    dfs(i,j);
                    home.add(homeInComplex);
                }
            }
        }
        Collections.sort(home);
        sb.append(complex).append("\n");
        for(int h : home){
            sb.append(h).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        homeInComplex++;
        for(int i = 0; i < 4; i++){
            int dx_x = x + dx[i];
            int dy_y = y + dy[i];

            if(dx_x >= 0 && dx_x < N && dy_y >= 0 && dy_y < N){
                if(!visited[dx_x][dy_y] && map[dx_x][dy_y] == 1){
                    dfs(dx_x, dy_y);
                }
            }
        }

    }
}