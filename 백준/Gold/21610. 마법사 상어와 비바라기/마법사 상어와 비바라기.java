import java.util.*;
import java.io.*;

class Main {
    static int[][] sky;
    static Queue<int[]> queue;
    static int N;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx2 = {1, 1, -1, -1};
    static int[] dy2 = {1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sky = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sky[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue = new LinkedList<>();
        queue.add(new int[]{N-1, 0});
        queue.add(new int[]{N-1, 1});
        queue.add(new int[]{N - 2, 0});
        queue.add(new int[]{N - 2, 1});

        for (int i = 0; i < M; i++) {
            int cloudSize = queue.size();
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            //모든 구름이 이동한다.
            for (int j = 0; j < cloudSize; j++) {
                //현재 구름 위치
                int[] q = queue.poll();

                //구름 이동
                moveCloud(q[0], q[1], d-1, s);
            }

            //구름이 있는 칸에 비가 1씩 내리고, 구름은 사라진다.
            for (int[] q : queue) {
                sky[q[0]][q[1]] += 1;
            }

            int[][] prevCloud = new int[N][N];

            //물복사버그 마법 시전
            while (!queue.isEmpty()) {
                int cx = queue.peek()[0];
                int cy = queue.peek()[1];
                prevCloud[cx][cy] = -1;
                queue.poll();
                addWater(cx, cy);
            }

            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(prevCloud[j][k] == -1) continue;
                    if(sky[j][k] >= 2){
                        queue.add(new int[]{j,k});
                        sky[j][k] -= 2;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += sky[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void moveCloud(int x, int y, int d, int s) {
        int nx = x;
        int ny = y;
        //구름의 이동
        for (int i = 0; i < s; i++) {
            nx += dx[d];
            ny += dy[d];
            //범위 벗어났을 때 처리
            if (nx == -1) {
                nx = N - 1;
            }
            if (nx == N) {
                nx = 0;
            }
            if (ny == -1) {
                ny = N - 1;
            }
            if (ny == N) {
                ny = 0;
            }
        }
        //새로운 구름 위치
        queue.add(new int[]{nx, ny});
    }

    public static void addWater(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx2[i];
            int ny = y + dy2[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (sky[nx][ny] > 0) {
                    count++;
                }
            }
        }
        sky[x][y] += count;
    }
}