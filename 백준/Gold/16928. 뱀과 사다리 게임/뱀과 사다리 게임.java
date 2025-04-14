import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        for(int i = 1; i <= 100 ; i++){
            board[i] = i;
        }

        //사다리 정보
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        //뱀 정보
        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

        boolean[] visited = new boolean[101];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,0));
        visited[1] = true;

        int answer = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int n = node.n;
            int cnt = node.cnt;

            if(n == 100){
                answer = cnt;
                break;
            }
            for(int i = 1; i <= 6; i++){
                int next = n+i;
                if(next <= 100 && !visited[next]){
                    visited[next] = true;
                    queue.add(new Node(board[n+i],cnt+1));
                }
            }
        }

        System.out.println(answer);
    }
}
class Node{
    int n;
    int cnt;
    public Node(int n, int cnt){
        this.n = n;
        this.cnt = cnt;
    }
}