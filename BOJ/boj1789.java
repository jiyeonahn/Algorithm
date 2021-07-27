import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N  = (long) Double.parseDouble(br.readLine());

        int max = (int) ((-1 + Math.sqrt(1+8*N)) / 2);

        System.out.println(max);
    }
}
