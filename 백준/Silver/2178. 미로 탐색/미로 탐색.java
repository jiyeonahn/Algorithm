import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        boolean[][] visited = new boolean[N][M];

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            visited[x][y] = true;

            for(int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        map[nx][ny] = map[x][y] + 1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

        System.out.println(map[N-1][M-1]);
    }
}