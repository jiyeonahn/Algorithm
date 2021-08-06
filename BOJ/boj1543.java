import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String key = br.readLine();
        int cnt = 0;

        int index = key.length();

        for(int i = 0; i < str.length(); i++){
            if(str.substring(i).length() < index) break;
            if(key.equals(str.substring(i, i + index))) {
                cnt++;
                i += key.length() - 1;
            }
        }
        System.out.println(cnt);
    }
}
