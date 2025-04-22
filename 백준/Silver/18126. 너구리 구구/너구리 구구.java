import java.util.*;
import java.io.*;
class Main{
    static int v;
    static long max;
    static boolean[] visited;
    static ArrayList<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new int[]{B,C});
            list[B].add(new int[]{A,C});
        }

        visited[1] = true;
        dfs(1,0);

        System.out.println(max);
    }

    public static void dfs(int cur, long dist){
        if(max < dist){
            max = dist;
            v = cur;
        }
        for (int[] l : list[cur]) {
            if(!visited[l[0]]){
                visited[l[0]] = true;
                dfs(l[0], dist+l[1]);
            }
        }
    }

}