import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9663 {//N-Queen
    static int N, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int col){
        if(col == N){//체스판에 N개의 퀸을 놓았을 때
            answer++;
            return;
        }
        for(int i = 0; i < N; i++){
            arr[col] = i;
            if(possibility(col)){//퀸을 놓을 수 있는 자리인지
                dfs(col+1);
            }
        }
    }

    private static boolean possibility(int col) {
        for(int i = 0; i < col; i ++){
            if(arr[col] == arr[i]){//이전 열들과 행이 같을때
                return false;
            }
            if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])){//대각선일때
                return false;
            }
        }
        return true;
    }

}