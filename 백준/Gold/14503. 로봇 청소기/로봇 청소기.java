import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];
        boolean[][] clean = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        //0:북 1:동 2:남 3:서
        int dir = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0};//북동남서
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.peek();
            int x = cur[0];
            int y = cur[1];

            if(!clean[x][y] && room[x][y] == 0){//현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다.
                count++;
                clean[x][y] = true;
            }

            boolean nearClean = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !clean[nx][ny] && room[nx][ny] == 0) {//청소 되지 않은 빈 칸이 있는 경우
                    nearClean = false;
                    break;
                }
            }
            int nx = 0;
            int ny = 0;
            if (nearClean) {//현재 칸의 주변 4칸 중 청소 되지 않은 빈 칸이 없는 경우
                //1칸 후진
                if (dir == 0) {//북
                    nx = x + dx[2];
                    ny = y + dy[2];
                } else if (dir == 1) {//동
                    nx = x + dx[3];
                    ny = y + dy[3];
                } else if (dir == 2) {//남
                    nx = x + dx[0];
                    ny = y + dy[0];
                } else if (dir == 3) {//동
                    nx = x + dx[1];
                    ny = y + dy[1];
                }
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    queue.poll();
                }else{
                    break;//후진할 수 없다면 작동을 멈춘다.
                }
            } else {//현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                //반시계 방향으로 90도 회전 후 전진
                if (dir == 0) {//북
                    dir = 3;
                } else if (dir == 1) {//동
                    dir = 0;
                } else if (dir == 2) {//남
                    dir = 1;
                } else if (dir == 3) {//서
                    dir = 2;
                }
                nx = x + dx[dir];
                ny = y + dy[dir];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !clean[nx][ny] && room[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    queue.poll();
                }
            }

        }

        System.out.println(count);
    }
}