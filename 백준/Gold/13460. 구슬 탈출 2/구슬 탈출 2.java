import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int redX = 0;
        int redY = 0;
        int blueX = 0;
        int blueY = 0;
        char[][] board = new char[N][M];

        //빨간구슬 빼내기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    redX = i;
                    redY = j;
                }
                if (board[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                }
            }
        }

        boolean[][][][] visited = new boolean[N][M][N][M];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(redX, redY, blueX, blueY, 0));
        visited[redX][redY][blueX][blueY] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.cnt >= 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int n_rx = node.rx;
                int n_ry = node.ry;

                int n_bx = node.bx;
                int n_by = node.by;

                //빨간 구슬 이동
                int redMove = 0;
                while (true) {
                    int next_rx = n_rx + dx[i];
                    int next_ry = n_ry + dy[i];

                    if (next_rx < 0 || next_rx >= N || next_ry < 0 || next_ry >= M) break;
                    if (board[next_rx][next_ry] == '#' || board[n_rx][n_ry] == 'O') break;

                    n_rx = next_rx;
                    n_ry = next_ry;
                    redMove++;
                }

                //파란 구슬 이동
                int blueMove = 0;
                while (true) {
                    int next_bx = n_bx + dx[i];
                    int next_by = n_by + dy[i];

                    if (next_bx < 0 || next_bx >= N || next_by < 0 || next_by >= M) break;
                    if (board[next_bx][next_by] == '#' || board[n_bx][n_by] == 'O') break;

                    n_bx = next_bx;
                    n_by = next_by;
                    blueMove++;
                }

                //파란 구슬이 구멍에 빠진 경우 => 실패
                if (board[n_bx][n_by] == 'O') {
                    continue;
                }

                //빨간 구슬이 구멍에 빠진 경우 => 성공
                if (board[n_rx][n_ry] == 'O') {
                    System.out.println(node.cnt + 1);
                    return;
                }

                //두 구슬이 같은 위치에 도착했을 경우
                if (n_rx == n_bx && n_ry == n_by) {
                    if (redMove > blueMove) {
                        n_rx -= dx[i];
                        n_ry -= dy[i];
                    } else {
                        n_bx -= dx[i];
                        n_by -= dy[i];
                    }
                }

                if (!visited[n_rx][n_ry][n_bx][n_by]) {
                    visited[n_rx][n_ry][n_bx][n_by] = true;
                    queue.add(new Node(n_rx, n_ry, n_bx, n_by, node.cnt + 1));
                }

            }
        }
        System.out.println(-1);
    }
}

class Node {
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    public Node(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}