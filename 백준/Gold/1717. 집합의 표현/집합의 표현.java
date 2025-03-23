import java.util.*;
import java.io.*;
class Main{
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x == 0){
                union(a,b);
            }
            if(x == 1){
                if(find(a) == find(b)){
                    sb.append("YES");
                }else{
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int target){//부모 찾기
        if(parent[target] != target){
            parent[target] = find(parent[target]);
        }
        return parent[target];
    }
    public static void union(int a, int b){//합치기
        int rootA = find(a);
        int rootB = find(b);
        if(rootA <= rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
    }
}