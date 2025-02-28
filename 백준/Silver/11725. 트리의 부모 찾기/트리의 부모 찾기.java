import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Integer>[] tree = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i = 0; i <= N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            tree[n].add(m);
            tree[m].add(n);
        }

        int[] parent = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); //루트 add
        visited[1] = true;
        while(!queue.isEmpty()){
            int root = queue.poll();
            for(int node : tree[root]){
                if(!visited[node]){
                    visited[node] = true;
                    parent[node] = root;
                    queue.add(node);
                }
            }
        }

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }
}
