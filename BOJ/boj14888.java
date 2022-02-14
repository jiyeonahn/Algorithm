import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888 {//연산자 끼워넣기
    static int N, max = -1000000000, min = 1000000000;
    static int[] num;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int result, int idx){
        if(idx == N-1){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(op[i] > 0){
                op[i]--;
                switch (i){
                    case 0:
                        dfs(result + num[idx + 1], idx + 1);
                        break;
                    case 1:
                        dfs(result - num[idx + 1], idx + 1);
                        break;
                    case 2:
                        dfs(result * num[idx + 1], idx + 1);
                        break;
                    case 3:
                        dfs(result / num[idx + 1], idx + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}
