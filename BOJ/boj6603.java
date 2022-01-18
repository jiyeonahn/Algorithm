import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj6603 {//로또
private static StringBuilder sb = new StringBuilder();

    public static void dfs(int[] S, int len, int[] arr, boolean[] visited, int preNum){
        if(len == 6){
            for(int n: arr)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 0; i < S.length; i++){
            if(!visited[i] && preNum < S[i]){
                visited[i] = true;
                arr[len] = S[i];
                dfs(S,len+1,arr,visited,S[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            int[] S = new int[k];
            boolean[] visited = new boolean[k];
            for(int i = 0; i < k; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }
            int[] arr = new int[6];
            Arrays.sort(S);
            dfs(S, 0, arr, visited,0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}