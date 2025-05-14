import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                queue.add(i);
            }
        }

        int[] arr = new int[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            arr[idx++] = queue.poll();
        }

        int left = 0;
        int right = 0;
        int sum = arr[0];
        int count = 0;
        while (left <= right) {
            if (sum <= N) {
                if (sum == N) {
                    count++;
                }
                right++;
                if (right >= arr.length) {
                    break;
                }
                sum += arr[right];

            } else {
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}