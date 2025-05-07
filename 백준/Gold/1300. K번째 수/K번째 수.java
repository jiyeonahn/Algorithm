import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long low = 1;
        long high = K;

        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += Math.min(mid / i, N);
            }

            if (sum < K) {
                low = mid + 1;
            } else if (sum >= K) {
                high = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}