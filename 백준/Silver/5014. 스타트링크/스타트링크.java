import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); // 총 층수
        int S = Integer.parseInt(st.nextToken()); // 강호가 있는 곳
        int G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (S == G) {
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        boolean[] visited = new boolean[F + 1];
        visited[S] = true;
        int floor = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int location = cur[0];
            int count = cur[1];

            if (location == G) {
                floor = count;
                break;
            }
            if (location + U >= 1 && location + U <= F && !visited[location + U]) {
                visited[location + U] = true;
                queue.add(new int[]{location + U, count + 1});
            }
            if (location - D >= 1 && location - D <= F && !visited[location - D]) {
                visited[location - D] = true;
                queue.add(new int[]{location - D, count + 1});
            }
        }
        System.out.println(floor == 0 ? "use the stairs" : floor);
    }
}