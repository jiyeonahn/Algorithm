import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] network = new ArrayList[N+1];

        for(int i = 0; i <= N; i++){
            network[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network[a].add(b);
            network[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        boolean[] visited = new boolean[N+1];
        visited[1] = true;

        int answer = -1;

        while(!queue.isEmpty()){
            int n = queue.poll();
            answer++;
            for(int v : network[n]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        System.out.println(answer);
    }
}