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
        StringBuilder sb = new StringBuilder("<");
        int index = 0;
        while(!queue.isEmpty()){
            index++;
            if(index == K){
                sb.append(queue.poll());
                if(queue.isEmpty()){
                    sb.append(">");
                }else{
                    sb.append(", ");
                }
                index = 0;
            }else{
                queue.add(queue.poll());
            }
        }
        System.out.println(sb);
    }
}