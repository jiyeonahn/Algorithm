import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        int sum = 0;

        for(int i = 0; i < str.length(); i++){
            int num = str.charAt(i) - '0';
            switch ((str.length()-i) % 3){
                case 0:
                    sum += 4 * num;
                    break;
                case 1:
                    sum += num;
                    sb.append(sum);
                    sum = 0;
                    break;
                case 2:
                    sum += 2 * num;
                    break;
            }
        }
        System.out.println(sb.toString());
    }

}
