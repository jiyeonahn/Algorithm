import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> primeList = new ArrayList<>();

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

        for (int i = 1; i <= N; i++) {
            if (prime[i]) {
                primeList.add(i);
            }
        }

        int left = 0;
        int right = 0;
        int sum = primeList.isEmpty() ? 0 : primeList.get(0);
        int count = 0;
        while (left <= right) {
            if (sum <= N) {
                if (sum == N) {
                    count++;
                }
                right++;
                if (right >= primeList.size()) {
                    break;
                }
                sum += primeList.get(right);

            } else {
                sum -= primeList.get(left);
                left++;
            }
        }

        System.out.println(count);
    }
}