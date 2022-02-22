import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj10026 {//적록색약
    private static int N;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N ; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){//같은 색들을 먼저 처리
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                visited[i][j] = false;
                if(map[i][j] == 'R')//R을 G로 바꾸기
                    map[i][j] = 'G';
            }
        }

        int cnt2 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    cnt2++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt + " " + cnt2);
    }
    private static void bfs(int a, int b){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int n = node.n;
            int m = node.m;
            visited[n][m] = true;

            for(int i = 0; i < 4; i++){
                int next_n = n + dx[i];
                int next_m = m + dy[i];

                if(next_n >= 0 && next_n < N && next_m >= 0 && next_m < N && !visited[next_n][next_m]){
                    if(map[n][m] == map[next_n][next_m]){
                        visited[next_n][next_m] = true;
                        queue.add(new Node(next_n, next_m));
                    }
                }
            }
        }
    }

    static class Node{
        int n, m;

        public Node(int n, int m){
            this.n = n;
            this.m = m;
        }
    }
}