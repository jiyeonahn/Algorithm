import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i*i <= N; i++){
            if(prime[i]){
                for(int j = i*i; j <= N; j+=i){//불필요한 반복을 막음
                    prime[j] = false;
                }
            }
        }

        if(N == 1){
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (prime[i]) {
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
}