import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759 {//암호 만들기
private static StringBuilder sb = new StringBuilder();
private static String[] alpha;
private static String[] arr;
private static boolean[] visited;
private static int L, C;

    public static void dfs(int len, String pre, int vowelsCount, int consonantCount){
        if(len == L){
            if(vowelsCount >= 1 && consonantCount >= 2){
                for(String s: arr)
                    sb.append(s);
                sb.append("\n");
            }
            return;
        }
        for(int i = 0; i < C; i++){
            if(!visited[i] && pre.compareTo(alpha[i]) <= 0){
                visited[i] = true;
                arr[len] = alpha[i];
                if(alpha[i].equals("a") || alpha[i].equals("e") || alpha[i].equals("i") || alpha[i].equals("o") || alpha[i].equals("u")) {
                    dfs(len+1, alpha[i], vowelsCount+1, consonantCount);
                }
                else {
                    dfs(len+1, alpha[i], vowelsCount, consonantCount+1);

                }
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[L];

        alpha = new String[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            alpha[i] = st.nextToken();
        }
        Arrays.sort(alpha);

        dfs(0,"a", 0,0);

        System.out.println(sb.toString());
    }

}