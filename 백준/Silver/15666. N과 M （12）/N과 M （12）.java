import java.util.*;
import java.io.*;
class Main{
    static int N,M;
    static int[] num, arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[N];
        arr = new int[M];

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0, 0);

        System.out.println(sb);
    }
    public static void dfs(int idx, int len){
        if(len == M){
            for(int n : arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        int preNum = 0;
        for(int i = idx; i < N; i++){
            if(preNum < num[i]){
                arr[len] = num[i];
                preNum = num[i];
                dfs(i, len+1);
            }
        }
    }
}