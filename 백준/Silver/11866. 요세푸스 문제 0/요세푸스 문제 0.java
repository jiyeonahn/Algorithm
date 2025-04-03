import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int[] answer = new int[N];

        int idx = 1;
        while(!queue.isEmpty()){
            int n = queue.poll();
            if(idx == K){
                idx = 0;
                sb.append(n);
                if(queue.size() > 0){
                    sb.append(", ");
                }
            }else{
                queue.add(n);
            }
            idx++;
        }

        sb.append(">");
        System.out.println(sb);
    }
}