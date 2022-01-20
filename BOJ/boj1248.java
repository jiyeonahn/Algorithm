import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1248 {//맞춰봐
    public static int N;
    public static char[][] arr;
    public static int[] answer;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int idx){
        if(idx == N){
            for(int n: answer)
                sb.append(n).append(" ");
            System.out.println(sb.toString());
            System.exit(0); // 시스템 강제 종료
        }

        for(int i = -10; i <= 10; i++){
            answer[idx] = i;
            if(check(idx)) dfs(idx+1);
        }

    }

    public static boolean check(int a){
        for(int i = 0; i <= a; i++){
            int sum = 0;
            for(int j = i; j <= a; j++){
                sum += answer[j];
                if((sum == 0 && arr[i][j] == '0') || (sum < 0 && arr[i][j] == '-') || (sum > 0 && arr[i][j] == '+')){
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        answer = new int[N];

        char[] ch = br.readLine().toCharArray();
        int idx = 0;

        for (int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                arr[i][j] = ch[idx++];
            }
        }

        dfs(0);
    }

}