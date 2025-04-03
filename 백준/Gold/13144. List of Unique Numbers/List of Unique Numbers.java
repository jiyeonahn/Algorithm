import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        long count = 0;
        HashSet<Integer> set = new HashSet<>();
        while (start < N) {
            while(end < N &&!set.contains(arr[end])){
                set.add(arr[end]);
                end++;
            }

            count += (end - start);
            set.remove(arr[start]);
            start++;
        }

        System.out.println(count);
    }
}