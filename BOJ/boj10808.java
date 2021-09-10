import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] cnt = new int[26];
        for(int i = 0; i < str.length(); i++){
            cnt[str.charAt(i)-'a']++;
        }

        for(int i : cnt){
            sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }
}
