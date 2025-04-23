import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j = a; j <= b; j++){
                set.add(j);
            }
        }

        boolean[] visited = new boolean[N+1];
        int answer = -1;
        Queue<int[]> queue = new LinkedList<>();
        if(!set.contains(A)){
            visited[A] = true;
            queue.add(new int[]{A,1});
        }
        if(!set.contains(B)){
            visited[B] = true;
            queue.add(new int[]{B,1});
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0] == N){
                answer = cur[1];
                break;
            }
            
            int nextTotalA = A+cur[0];
            if(nextTotalA <= N && !set.contains(nextTotalA) && !visited[nextTotalA]){
                visited[nextTotalA] = true;
                queue.add(new int[]{nextTotalA, cur[1]+1});
            }
            
            int nextTotalB = B+cur[0];
            if(nextTotalB <= N && !set.contains(nextTotalB) && !visited[nextTotalB]){
                visited[nextTotalB] = true;
                queue.add(new int[]{nextTotalB, cur[1]+1});
            }
        }

        System.out.println(answer);
    }
}