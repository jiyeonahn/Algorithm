import java.io.*;
import java.util.Arrays;

public class boj11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        String[] ans = new String[str.length()];

        for(int i = 0; i < str.length(); i++){
            ans[i] = str.substring(i);
        }

        Arrays.sort(ans);

        for(String s : ans)
            sb.append(s).append("\n");

        System.out.println(sb.toString());
    }
}