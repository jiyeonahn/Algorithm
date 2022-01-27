import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2667 {//단지 번호 붙이기
    private static int complexCnt, N;
    private static int[] complex = new int[25*25];
    private static int[] dx = {0, 1, -1, 0};
    private static int[] dy = {1, 0, 0, -1};

    private static int[][] map;
    private static boolean[][] visited;

    public static void dfs(int i, int j){
        visited[i][j] = true;
        complex[complexCnt]++;

        for(int d = 0; d < 4; d++){
            int next_i = i + dx[d];
            int next_j = j + dy[d];

            if(next_i >= 0 && next_i < N && next_j >= 0 && next_j < N && !visited[next_i][next_j] && map[next_i][next_j] == 1){
                visited[next_i][next_j] = true;
                dfs(next_i, next_j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
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

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    complexCnt++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(complexCnt);
        Arrays.sort(complex);
        for (int value : complex) {
            if (value != 0)
                System.out.println(value);
        }
    }

}
