import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16947 {//서울 지하철 2호선 ★★★★★
    private static int N;
    private static int[] answer;
    private static ArrayList<Integer>[] map;
    private static boolean[] cycle;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static boolean isCycle(int idx, int start, int cnt) {
        visited[idx] = true;

        for (int v : map[idx]) {
            if (!visited[v]) {
                if (isCycle(v, start, cnt + 1)) {
                    cycle[v] = true;
                    return true;
                }
            } else if (cnt >= 2 && v == start) {
                cycle[v] = true;
                return true;
            }
        }
        return false;
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        for(int i=1; i <= N; i++){
            if(cycle[i]) {
                visited[i] = true;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : map[u]){
                if(!visited[v]){
                    q.offer(v);
                    visited[v] = true;
                    answer[v] = answer[u]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cycle = new boolean[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map[n].add(m);
            map[m].add(n);
        }

        for (int i = 1; i <= N; i++) {
            if (isCycle(i, i, 0))
                break;
            else Arrays.fill(visited, false);
        }

        bfs();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}