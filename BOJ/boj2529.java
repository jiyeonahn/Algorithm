import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2529 {//부등호
    public static boolean[] visited = new boolean[10];
    public static long[] arr;
    public static String[] inequality;
    public static int N;
    public static long max, min = 9876543210L;

    public static void dfs(int len, String sign, int idx){
        if(len == N+1){
            StringBuilder sb = new StringBuilder();
            for(long num: arr)
                sb.append(num);

            max = Math.max(max, Long.parseLong(sb.toString()));
            min = Math.min(min, Long.parseLong(sb.toString()));
            return;
        }
        if(sign.equals("<")){
            for(int i = idx + 1; i < 10; i++){
                if(!visited[i]){
                    visited[i] = true;
                    arr[len] = i;
                    if(len != N) dfs(len+1, inequality[len], i);
                    else dfs(len+1, "end", i);
                    visited[i] = false;
                }
            }
        }
        else if(sign.equals(">")){
            for(int i = idx - 1; i >= 0; i--){
                if(!visited[i]){
                    visited[i] = true;
                    arr[len] = i;
                    if(len != N) dfs(len+1, inequality[len], i);
                    else dfs(len+1, "end", i);
                    visited[i] = false;
                }
            }
        }
        else{
            for(int i = 0; i < 10; i++){
                if(!visited[i]){
                    visited[i] = true;
                    arr[len] = i;
                    dfs(len+1, inequality[len], i);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int n = N+1;
        inequality = new String[N];
        arr = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inequality[i] = st.nextToken();
        }

        dfs(0, "start", 0);

        System.out.println(String.format("%0"+n+"d", max));
        System.out.println(String.format("%0"+n+"d", min));

    }

}