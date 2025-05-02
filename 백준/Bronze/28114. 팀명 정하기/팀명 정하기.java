import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] year = new int[3];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.p-a.p);

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            char S = st.nextToken().charAt(0);
            year[i] = Y%100;
            pq.add(new Node(P,S));
        }

        Arrays.sort(year);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            sb.append(year[i]);
        }

        sb.append("\n");

        while(!pq.isEmpty()){
            Node node = pq.poll();
            sb.append(node.s);
        }

        System.out.println(sb);
    }
}
class Node{
    int p;
    char s;
    public Node(int p, char s){
        this.p = p;
        this.s = s;
    }
}