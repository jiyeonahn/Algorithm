import java.util.*;
import java.io.*;
class Main{
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0,0,arr[0][0]-'0',' ');

        System.out.println(max + " " + min);
    }
    public static void dfs(int x, int y, int result, char type){
        if(x == N-1 && y == N-1){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(arr[nx][ny] == '*' || arr[nx][ny] == '+' || arr[nx][ny] == '-'){
                        dfs(nx,ny,result,arr[nx][ny]);
                    }else{
                        if(type == '*'){
                            dfs(nx,ny,result*(arr[nx][ny]-'0'),' ');
                        }
                        if(type == '+'){
                            dfs(nx,ny,result+(arr[nx][ny]-'0'),' ');
                        }
                        if(type == '-'){
                            dfs(nx,ny,result-(arr[nx][ny]-'0'),' ');
                        }
                    }
                    visited[nx][ny] = false;
                }
            }
        }
    }
}