import java.util.*;
import java.io.*;
class Main{
    static int[] arr;
    static boolean[] visited;
    static int max;
    static int N;
    public static void dfs(int current, int sum, int len){
        if(len == N-1){
            max = Math.max(max, sum);
            return;
        }

        visited[current] = true;
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, sum + Math.abs(arr[i]-arr[current]), len + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            dfs(i, 0, 0);
        }

        System.out.println(max);
    }
}