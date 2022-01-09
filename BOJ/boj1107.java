import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();//이동해야 할 채널
        int M = Integer.parseInt(br.readLine());
        int answer;

        boolean[] num = new boolean[10];

        for (int i = 0; i < 10; i++) {
            num[i] = true;
        }

        if(M!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                num[Integer.parseInt(st.nextToken())] = false;
            }
        }

        answer = Math.abs(100-Integer.parseInt(N));
        for(int i = 0; i <= 999999; i++){
            if(answer == 0) break;
            String numStr = String.valueOf(i);
            boolean isBreak = false;

            for(int j = 0; j < numStr.length(); j++){
                if(!num[numStr.charAt(j) - '0']){
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak)
                answer = Math.min(answer, Math.abs(i-Integer.parseInt(N))+numStr.length());
        }
        System.out.println(answer);
    }

}