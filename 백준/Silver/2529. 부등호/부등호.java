import java.util.*;
import java.io.*;
class Main{
    static boolean[] visited;
    static int[] arr;
    static String[] sign;
    static int k;
    static long min = Long.MAX_VALUE, max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sign = new String[k];

        for(int i = 0; i < k; i++){
            sign[i] = st.nextToken();
        }

        arr = new int[k+1];
        for(int i = 0; i <= 9; i++){
            visited = new boolean[10];
            arr[0] = i;
            visited[i] = true;
            dfs(i, 1);
        }
        System.out.println(max);
        System.out.println(String.valueOf(min).length() == k ? "0"+min : min);
    }
    public static void dfs(int current, int index){
        if(index == k+1){
            StringBuilder sb = new StringBuilder();
            for(int n : arr){
                sb.append(n);
            }
            min = Math.min(min, Long.parseLong(sb.toString()));
            max = Math.max(max, Long.parseLong(sb.toString()));
            return;
        }
        if("<".equals(sign[index-1])){
            for(int i = current+1; i <= 9; i++){
                if(!visited[i]){
                    visited[i] = true;
                    arr[index] = i;
                    dfs(i,index+1);
                    visited[i] = false;
                }
            }
        }else if(">".equals(sign[index-1])){
            for(int i = current-1; i >= 0; i--){
                if(!visited[i]){
                    visited[i] = true;
                    arr[index] = i;
                    dfs(i, index+1);
                    visited[i] = false;
                }
            }
        }
    }
}