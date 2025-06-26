import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{N, 0});

        boolean[] visited = new boolean[100001];

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == K) {
                answer = now[1];
                break;
            }

            if (now[0] + 1 <= 100000 && !visited[now[0] + 1]) {
                visited[now[0]+1] = true;
                queue.add(new int[]{now[0] + 1, now[1] + 1});
            }

            if (now[0] - 1 >= 0 && !visited[now[0] - 1]) {
                visited[now[0]-1] = true;
                queue.add(new int[]{now[0] - 1, now[1] + 1});
            }

            if (now[0] * 2 <= 100000 && !visited[now[0] * 2]) {
                visited[now[0]*2] = true;
                queue.add(new int[]{now[0] * 2, now[1] + 1});
            }
        }

        System.out.println(answer);
    }
}