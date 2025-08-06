import java.util.*;
import java.io.*;

class Main {
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    static ArrayList<Integer>[] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        dist = new int[N];
        Arrays.fill(dist, INF);

        city = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            city[A].add(B);
        }
        dist[X-1] = 0;
        dijkstra(X-1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if(dist[i] == K){
                sb.append(i+1).append("\n");
            }
        }
        if(sb.toString().length() == 0){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }
    }

    public static void dijkstra(int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int n = now[0];
            int l = now[1];

            for (int next : city[n]) {
                int newCost = dist[n] + 1;
                if(newCost < dist[next]){
                    dist[next] = Math.min(dist[next], newCost);
                    queue.add(new int[]{next, newCost});
                }
                
            }
        }
    }
}