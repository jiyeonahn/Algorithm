import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());//편의점 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());

            int[][] conv = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                conv[j][0] = Integer.parseInt(st.nextToken());
                conv[j][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] festival = new int[2];
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());

            //20개의 맥주로 1000까지 갈 수 있음
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{homeX, homeY});

            boolean[] visited = new boolean[n];

            boolean isHappy = false;
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (distance(cur, festival)) {
                    isHappy = true;
                    break;
                }

                for (int j = 0; j < n; j++) {
                    if (distance(cur, conv[j]) && !visited[j]) {
                        visited[j] = true;
                        queue.add(new int[]{conv[j][0], conv[j][1]});
                    }
                }
            }
            sb.append(isHappy ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }
    static boolean distance(int[] a, int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]) <= 1000;
    }
}