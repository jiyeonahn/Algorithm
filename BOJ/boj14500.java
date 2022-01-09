import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 {
    public static int N, M, answer;
    public static boolean[][] visited;
    public static int[][] arr;
    public static int[] dx = {0,1,-1,0};
    public static int[] dy = {1,0,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(i,j,1, arr[i][j]);
                visited[i][j] = false;
                check(i,j);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int count, int sum){
        if(count >= 4){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int X = dx[i] + x;
            int Y = dy[i] + y;

            if(X >= 0 && Y >= 0 && X < N && Y < M && !visited[X][Y]){
                visited[X][Y] = true;
                dfs(X, Y, count+1, sum + arr[X][Y]);//count++:시간초과, ++count:틀림, count는 변수가 아님 just숫자
                visited[X][Y] = false;
            }
        }
    }

    public static void check(int i, int j){
        if(i < N-2 && j < M-1){
            answer = Math.max(answer, arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j]);
        }
        if(i < N-1 && j < M-2){
            answer = Math.max(answer, arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]);
        }
        if(i >= 1 && i < N - 1 && j < M - 1){
            answer = Math.max(answer, arr[i][j] + arr[i-1][j+1] + arr[i][j+1] + arr[i+1][j+1]);
        }
        if(i >= 1 && i < N  && j < M-2){
            answer = Math.max(answer, arr[i][j] + arr[i-1][j+1] + arr[i][j+1] + arr[i][j+2]);
        }
    }
}