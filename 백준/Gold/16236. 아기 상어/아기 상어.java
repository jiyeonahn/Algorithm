import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] fish = new int[N][N];
        int sharkX = 0;
        int sharkY = 0;

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                fish[i][j] = Integer.parseInt(st.nextToken());
                if (fish[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        int power = 2; //상어의 크기
        int count = 0; //물고기 먹은 개수
        int time = 0;

        while (true) {
            //x좌표, y좌표, 거리
            //가까운 물고기 > 가장 위에 있는 물고기 > 가장 왼쪽에 있는 물고기
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[2] != b[2]) {
                    return a[2] - b[2];
                }
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            boolean[][] visited = new boolean[N][N];
            //상어 위치 초기화
            fish[sharkX][sharkY] = 0;
            pq.add(new int[]{sharkX, sharkY, 0});
            visited[sharkX][sharkY] = true;

            if (power == count) {
                power++;
                count = 0;
            }

            boolean callmom = true;

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int x = cur[0];
                int y = cur[1];
                int dist = cur[2];
                //자신의 크기보다 작은 물고리만 먹을 수 있다.
                if (power > fish[x][y] && fish[x][y] > 0) {
                    sharkX = x;
                    sharkY = y;
                    count++;
                    time += dist;
                    callmom = false;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        //자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
                        if (power < fish[nx][ny]) {
                            continue;
                        }

                        //나머지 칸은 모두 지나갈 수 있다.
                        pq.add(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
            //더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
            if (callmom) {
                break;
            }
        }

        System.out.println(time);
    }
}