import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        int[] fre = new int[1000001];
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        for(int i = 0; i < N; i++){
            fre[arr[i]]++;
        }//fre[1] = 3, fre[2] = 2, fre[3] = 1, fre[4] = 1

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && fre[stack.peek()] <= fre[arr[i]]) {
                stack.pop();
            }
            if(stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();

            stack.push(arr[i]);
        }

        for (int i : answer) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}
