import java.util.*;
import java.io.*;

class Main {
    static int M, N;
    static int[][] box;
    static boolean[][] visited;
    static int answer;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸 수
        N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸 수

        box = new int[N][M];
        visited = new boolean[N][M];

        int greenTomato = 0; //안 익은 토마토
        int beRedTomato = 0; //익을 수 있는 토마토

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 0){
                    greenTomato++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {//익은 토마토 찾기
                    queue.add(new Node(i,j,0));
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int day = node.day;

            answer = day;

            for (int i = 0; i < 4; i++) {
                int dx_x = x + dx[i];
                int dy_y = y + dy[i];
                if (dx_x >= 0 && dx_x < N && dy_y >= 0 && dy_y < M) {
                    if (box[dx_x][dy_y] == 0) {
                        box[dx_x][dy_y] = 1;
                        beRedTomato++;
                        queue.add(new Node(dx_x,dy_y,day+1));
                    }
                }

            }
        }
        System.out.println( (greenTomato == beRedTomato) ? answer : -1);
    }
}
class Node{
    int x;
    int y;
    int day;
    public Node(int x, int y, int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}