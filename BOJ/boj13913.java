import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj13913 {//숨바꼭질 4
    public static boolean[] visited;
    public static int[] arr;
    public static int[] ans = new int[100001];
    public static int[] parent = new int[100001];
    public static int answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] lc = new int[3];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()) {
            int n = q.poll();

            if(n == K) {
                System.out.println(0);
                break;
            }

            lc[0] = n + 1;
            lc[1] = n - 1;
            lc[2] = n * 2;

            for (int i = 0; i < 3; i++) {
                if (lc[i] >= 0 && lc[i] <= 100000 && ans[lc[i]] == 0) {
                    ans[lc[i]] = ans[n] + 1;
                    parent[lc[i]] = n;
                    if (lc[i] == K) {
                        answer = ans[lc[i]];
                        System.out.println(answer);
                        visited = new boolean[answer+1];
                        q.clear();
                        break;
                    }
                    q.add(lc[i]);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int index = K;
        stack.add(index);

        while(index != N){
            stack.add(parent[index]);
            index = parent[index];
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());

    }


}