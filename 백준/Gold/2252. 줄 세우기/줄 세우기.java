import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] line = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
            line[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (line[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int n = queue.poll();
            sb.append(n).append(" ");

            for (int connect : arr[n]) {
                line[connect]--;
                if (line[connect] == 0) {
                    queue.add(connect);
                }
            }
        }

        System.out.println(sb);
    }
}