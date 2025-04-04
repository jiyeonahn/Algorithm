import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] family = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            family[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            family[x].add(y);
            family[y].add(x);
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(new int[]{a, 0});
        visited[a] = true;
        int count = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int p = cur[0];
            int cnt = cur[1];

            if (p == b) {
                count = cnt;
                break;
            }

            for (int f : family[p]) {
                if (!visited[f]) {
                    visited[f] = true;
                    queue.add(new int[]{f, cnt + 1});
                }
            }
        }
        System.out.println(count);
    }
}