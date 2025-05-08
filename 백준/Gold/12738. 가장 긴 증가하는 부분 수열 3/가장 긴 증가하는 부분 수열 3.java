import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1000000001);

        for (int i = 0; i < N; i++) {
            int target = -1;
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int left = 0;
                int right = list.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[i] <= list.get(mid)) {
                        right = mid - 1;
                        target = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            if (target > 0) {
                list.set(target, arr[i]);
            }
        }

        System.out.println(list.size() - 1);
    }
}