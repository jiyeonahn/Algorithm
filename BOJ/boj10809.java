import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] cnt = new int[26];

        Arrays.fill(cnt, -1);

        for(int i = 0; i < str.length(); i++){
            if(cnt[str.charAt(i)-'a'] != -1) continue;
            cnt[str.charAt(i)-'a'] = i;
        }

        for(int i : cnt){
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}
