import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj1339 {//단어 수학

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] alpha = new Integer[26];
        Arrays.fill(alpha, 0);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'A'] += (int)Math.pow(10, (str.length() - j - 1));
            }
        }
        Arrays.sort(alpha, Collections.reverseOrder());

        int n = 9;
        int answer = 0;
        for(int i = 0; i < 10; i++){
            if(alpha[i] == 0) break;
            answer += alpha[i] * n;
            n--;
        }

        System.out.println(answer);
    }
}