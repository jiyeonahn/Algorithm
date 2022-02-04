import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13549 {//숨바꼭질 3

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = 100000;
        boolean[] visited = new boolean[100001];
        int answer = 100001;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N,0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;

            if(node.x == K){
                answer = Math.min(answer, node.time);
            }

            if(node.x * 2 <= max && !visited[node.x * 2]) q.offer(new Node(node.x * 2, node.time));
            if(node.x + 1 <= max && !visited[node.x + 1]) q.offer(new Node(node.x + 1, node.time + 1));
            if(node.x - 1 >= 0 && !visited[node.x - 1]) q.offer(new Node(node.x - 1, node.time + 1));
        }

        System.out.println(answer);
    }

    public static class Node{
        int x;
        int time;

        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
}