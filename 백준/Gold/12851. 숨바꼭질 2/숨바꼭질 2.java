import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//수빈의 위치
        int K = Integer.parseInt(st.nextToken());//동생의 위치

        int[] visited = new int[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        Arrays.fill(visited, -1);
        visited[N] = 0;

        int min = 100001;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int location = cur[0];
            int time = cur[1];

            if (time > min) {
                break;
            }

            if (location == K) {
                if (min == 100001) {
                    min = time; //가장 빠른 시간
                }
                if (time == min) {
                    count++;
                }
            }

            int[] next = {location + 1, location - 1, location * 2};
            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] <= 100000) {
                    if (visited[next[i]] == -1 || visited[next[i]] == time + 1) {//방문하지 않았거나, 같은 시간대에 방문하거나
                        visited[next[i]] = time + 1;
                        queue.add(new int[]{next[i], time + 1});
                    }
                }
            }
        }

        System.out.println(min);
        System.out.println(count);
    }
}