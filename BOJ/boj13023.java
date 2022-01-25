import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj13023 {//ABCDE
    private static int N, M;
    private static boolean[] visited;
    private static ArrayList<Integer>[] relation;

    public static void dfs(int len, int idx) {
        if (len == 4) {
            System.out.println(1);
            System.exit(0);
            return;
        }

        for (int j = 0; j < relation[idx].size(); j++) {
            if(!visited[relation[idx].get(j)]) {
                visited[relation[idx].get(j)] = true;
                dfs(len + 1, relation[idx].get(j));
                visited[relation[idx].get(j)] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        relation = new ArrayList[N];
        for(int i = 0; i < N; i++){
            relation[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a].add(b);
            relation[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(0, i);
            visited[i] = false;
        }

        System.out.println(0);
    }
}