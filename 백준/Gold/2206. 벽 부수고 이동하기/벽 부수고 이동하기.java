import java.util.*;
import java.io.*;
class Main{
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = INF;

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true; //0:벽을 부수지 않은 채 이동, 1: 벽을 부순 채 이동
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int dist = node.dist;
            int breakMove = node.breakMove;

            if(x == N-1 && y == M-1){
                answer = Math.min(answer, dist);
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    int next = map[nx][ny];
                    if(next == 0){
                        if(breakMove == 0 && !visited[nx][ny][0]){
                            visited[nx][ny][0] = true;
                            queue.add(new Node(nx, ny, dist+1, breakMove));
                        }

                        if(breakMove == 1 && !visited[nx][ny][1]){
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, dist+1, 1));
                        }
                    }
                    if(next == 1 && breakMove == 0 && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, dist+1, 1));
                    }
                }
            }
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}

class Node{
    int x;
    int y;
    int dist;
    int breakMove;

    public Node(int x, int y, int dist, int breakMove) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.breakMove = breakMove;
    }
}