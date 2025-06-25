import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, 0});
        boolean[] visited = new boolean[n+1];
        visited[a] = true;
        int answer = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == b){
                answer = now[1];
                break;
            }

            for(int l : list[now[0]]){
                if(!visited[l]){
                    visited[l] = true;
                    queue.add(new int[]{l, now[1]+1});
                }
            }
        }

        System.out.println(answer == 0 ? -1 : answer);
    }
}