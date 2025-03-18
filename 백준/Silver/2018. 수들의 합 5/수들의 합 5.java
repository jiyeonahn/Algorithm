import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while (start < N) {
            if (sum < N) {
                end++;
                sum += end;
            }
            if (sum == N) {
                count++;
                end++;
                sum += end;
            }
            if (sum > N) {
                sum -= start;
                start++;

            }
        }
        System.out.println(count);
    }
}