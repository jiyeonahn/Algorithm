import java.util.*;
import java.io.*;
class Main{
    static int N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int current;
    static int[][] island;
    static boolean[][] visited;
    static Queue<int[]> coastline = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        island = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        // 섬 구분하기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && island[i][j] == 1){
                    current++;
                    dfs(i,j);
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        while(!coastline.isEmpty()){
            int[] c = coastline.poll();
            int distance = bfs(c[0], c[1]); //현재 해안선을 기준으로 최단 경로 찾기
            answer = Math.min(distance, answer);
            
            if(answer == 1) break; //최소값을 만나면 반복문 빠져나오기
        }
        System.out.println(answer);
    }
    public static void dfs(int n, int m){
        visited[n][m] = true;
        island[n][m] = current;
        boolean isCoastLine = false;
        for(int i = 0; i < 4; i++){
            int nx = n+dx[i];
            int ny = m+dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(!visited[nx][ny] && island[nx][ny] == 1){
                    dfs(nx,ny);
                }
                if(!isCoastLine && island[nx][ny] == 0){ //해안선 위치를 큐에 넣음
                    isCoastLine = true;
                    coastline.add(new int[] {n,m});
                }
            }
        }
    }
    public static int bfs(int n, int m){
        int land = island[n][m]; // 현재 육지
        Queue<int[]> bridge = new LinkedList<>();
        boolean[][] sea_visited = new boolean[N][N];

        bridge.add(new int[]{n,m});

        int bridgeCount = 0;

        while(!bridge.isEmpty()){
            int size = bridge.size();
            for(int t = 0; t < size; t++){
                int x = bridge.peek()[0];
                int y = bridge.peek()[1];
                bridge.poll();

                for(int i = 0; i < 4; i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                        if(!sea_visited[nx][ny] && island[nx][ny] == 0){//다리를 놓을 수 있음
                            sea_visited[nx][ny] = true;
                            bridge.add(new int[]{nx,ny});
                        }else if(island[nx][ny] != land && island[nx][ny] != 0){//다른 육지가 나온다면..
                            return bridgeCount;
                        }
                    }
                }
            }
            bridgeCount++;
        }
        return bridgeCount;
    }
}