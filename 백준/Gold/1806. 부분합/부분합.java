import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int len = 100001;
        int sum = arr[0];
        while (left <= right && right < N) {
            if (sum < S) {
                right++;
                if (right < N) {
                    sum += arr[right];
                }

            } else {
                len = Math.min(len, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(len == 100001 ? 0 : len);
    }
}