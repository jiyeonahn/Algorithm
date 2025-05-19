import java.util.*;
import java.io.*;
class Main{
    static boolean[][] visited;
    static char C;
    static char[][] color;
    static int N;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        color = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            color[i] = str.toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        visited = new boolean[N][N];
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    count++;
                    C = color[i][j];
                    dfs(i,j);
                }
            }
        }

        sb.append(count).append(" ");

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(color[i][j] == 'R'){
                    color[i][j] = 'G';
                }
            }
        }

        visited = new boolean[N][N];
        count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    count++;
                    C = color[i][j];
                    dfs(i,j);
                }
            }
        }

        sb.append(count);

        System.out.println(sb);
    }
    public static void dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(!visited[nx][ny] && color[nx][ny] == C){
                    visited[nx][ny] = true;
                    dfs(nx,ny);
                }
            }
        }
    }
}