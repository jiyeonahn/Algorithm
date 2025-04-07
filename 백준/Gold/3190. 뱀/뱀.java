import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = -1;//사과 위치
        }

        Queue<Node> queue = new LinkedList<>();
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            queue.add(new Node(X, C));
        }

        int headX = 1;
        int headY = 1;
        int tailX = 1;
        int tailY = 1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int idx = 0;//초기에는 오른쪽으로 이동
        int time = 0;

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1});
        board[1][1] = 1; //뱀 위치 표시

        Node node = queue.poll();
        int num = node.num;
        int next = node.ch;
        while (true) {
            time++;

            headX += dx[idx % 4];
            headY += dy[idx % 4];

            //벽에 부딪힘
            if (headX <= 0 || headX > N || headY <= 0 || headY > N) {
                break;
            }

            //뱀의 머리 이동
            snake.addFirst(new int[]{headX, headY});

            //얼굴이랑 다른 몸통이랑 위치가 같은면? => 몸통 부딪힘 => 얘 지금 제대로 계산 안 되는 듯
            boolean gameOver = false;
            for(int[] part : snake){
                if(part == snake.peekFirst()) continue;
                if (headX == part[0] && headY == part[1]) {
                    gameOver = true;
                    break;
                }
            }
            if (gameOver) break;

            //이동한 칸에 사과가 있다면
            if (board[headX][headY] != -1) {//사과가 없다면
                //꼬리를 머리 방향으로 한 칸 앞으로
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            board[headX][headY] = 1;

            //X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전
            if (time == num) {
                if (next == 'D') {//시계방향
                    idx++;
                    if (idx == 4) {
                        idx = 0;
                    }
                }
                if (next == 'L') {//반시계방향
                    idx--;
                    if (idx == -1) {
                        idx = 3;
                    }
                }
                if (!queue.isEmpty()) {
                    num = queue.peek().num;
                    next = queue.peek().ch;
                    queue.poll();
                }
            }

        }
        System.out.println(time);
    }
}

class Node {
    int num;
    char ch;

    public Node(int num, char ch) {
        this.num = num;
        this.ch = ch;
    }
}