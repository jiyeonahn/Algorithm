import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(1);

        int num = 2;
        int idx = 0;

        StringBuilder sb = new StringBuilder();

        sb.append("+").append("\n");

        int cnt = 0;

        while (num <= n + 1) {
            if (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            } else {
                if (num == n + 1) {
                    break;
                }
                stack.push(num++);
                sb.append("+").append("\n");
            }
        }

        System.out.println(idx < n ? "NO" : sb);

    }
}