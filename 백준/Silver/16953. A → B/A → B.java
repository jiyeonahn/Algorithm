import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(A==B){
            System.out.println(1);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{A,0});

        boolean[] visited = new boolean[B+1];
        visited[A] = true;
        int answer = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int num = cur[0];
            int cnt = cur[1];

            if(num == B){
                answer = cnt;
                break;
            }

            long next1 = num*2;
            long next2 = Long.parseLong(num+"1");

            if(next1 <= B && !visited[(int) next1]){
                visited[(int) next1] = true;
                queue.add(new int[]{(int) next1,cnt+1});
            }

            if(next2 <= B && !visited[(int) next2]){
                visited[(int) next2] = true;
                queue.add(new int[]{(int) next2,cnt+1});
            }
        }

        System.out.println(answer == 0 ? -1 : answer+1);
    }
}