import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] computer = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            computer[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computer[a].add(b);
            computer[b].add(a);
        }

        boolean[] visited = new boolean[N+1];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int virus = queue.poll();
            for(int v : computer[virus]){
                if(!visited[v]){
                    count++;
                    visited[v] = true;
                    queue.add(v);
                }

            }
        }
        System.out.println(count);
    }
}