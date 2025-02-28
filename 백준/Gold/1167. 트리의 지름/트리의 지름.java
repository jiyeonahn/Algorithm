import java.util.*;
import java.io.*;

public class Main {//트리의 지름
    private static ArrayList<Node>[] list;
    private static int answer, node;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new boolean[N];
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            while (st.hasMoreTokens()) {
                int l = Integer.parseInt(st.nextToken()) - 1;
                if (l == -2) break;
                int d = Integer.parseInt(st.nextToken());
                list[n].add(new Node(l, d));
            }
        }

        visited[0] = true;
        dfs(0, 0);
        Arrays.fill(visited,false);

        visited[node] = true;
        dfs(node, 0);
        System.out.println(answer);
    }

    static void dfs(int start, int sum) {
        if(sum > answer){
            answer = sum;
            node = start;
        }
        for (Node i : list[start]) {
            if (!visited[i.link]) {
                visited[i.link] = true;
                dfs(i.link, sum + i.distance);
            }
        }
    }

    static class Node {
        int link;
        int distance;

        public Node(int link, int distance) {
            this.link = link;
            this.distance = distance;
        }
    }
}
