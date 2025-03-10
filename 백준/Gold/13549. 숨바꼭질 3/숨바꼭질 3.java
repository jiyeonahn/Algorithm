import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.add(new int[]{N, 0});
        visited[N] = true;

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int location = cur[0];
            int time = cur[1];
            visited[location] = true;

            if (location == K) {
                answer = Math.min(time, answer);
            }

            int next = location + 1;
            if (next <= 100000 && !visited[next]) {
                queue.add(new int[]{next, time + 1});
            }
            next = location - 1;
            if (next >= 0 && !visited[next]) {
                queue.add(new int[]{next, time + 1});
            }
            next = location * 2;
            if (next <= 100000 && !visited[next]) {
                queue.add(new int[]{next, time});
            }
        }
        System.out.println(answer);
    }
}
