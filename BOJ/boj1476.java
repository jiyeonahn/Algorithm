import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1476 {
    public static int MAX = 15 * 28 * 19;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int startNum = Math.max(E,Math.max(S,N));
        int answer = 0;

        for(int i = startNum; i <= MAX; i++){
            if((i-E) % 15 == 0 && (i-S) % 28 == 0 && (i-N) % 19 == 0){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}