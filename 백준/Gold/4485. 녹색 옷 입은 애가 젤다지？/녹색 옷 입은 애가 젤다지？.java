import java.util.*;
import java.io.*;
class Main{
    static int min = Integer.MIN_VALUE;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N;
    static int[][] map;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while((N  = Integer.parseInt(br.readLine())) != 0){
            map = new int[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            dijkstra();
            sb.append("Problem ").append(tc++).append(": ").append(dist[N-1][N-1]).append("\n");

        }
        System.out.println(sb);
    }
    public static void dijkstra(){
        dist[0][0] = map[0][0];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.cost,b.cost));
        pq.add(new Node(0,0,map[0][0]));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            int cost = node.cost;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    int newCost = map[nx][ny] + cost;
                    if(newCost < dist[nx][ny]){
                        dist[nx][ny] = newCost;
                        pq.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }
    }
}
class Node{
    int x;
    int y;
    int cost;
    public Node(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}