import java.util.*;
import java.io.*;
class Main{
    static int min = Integer.MAX_VALUE;
    static int N,M;
    static int[][] arr;
    static int[] dx = {1,1,1};
    static int[] dy = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            dfs(0,i, -1, arr[0][i]);
        }

        System.out.println(min);
    }
    public static void dfs(int x, int y, int dir, int sum){
        if(x == N-1){
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < 3; i++){
            if(i != dir){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx < N && ny >= 0 && ny < M){
                    dfs(nx,ny,i,sum+arr[nx][ny]);
                }
            }
        }
    }
}