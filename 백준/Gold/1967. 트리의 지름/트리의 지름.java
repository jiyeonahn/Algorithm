import java.util.*;
import java.io.*;
class Main{
    static boolean[] visited;
    static int longest;
    static int longestV;
    static ArrayList<Node>[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[n+1];
        visited[longestV] = true;
        dfs(longestV,0);

        System.out.println(longest);
    }
    public static void dfs(int vertex, int distance){
        if(longest < distance){
            longest = distance;
            longestV = vertex;
        }
        for(Node node : tree[vertex]){
            int v = node.v;
            int d = node.d;

            if(!visited[v]){
                visited[v] = true;
                dfs(v, distance + d);
            }
        }
    }
}
class Node{
    int v;
    int d;

    public Node(int v, int d){
        this.v = v;
        this.d = d;
    }
}