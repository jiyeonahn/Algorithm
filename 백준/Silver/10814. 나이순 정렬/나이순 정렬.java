import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>(
            Comparator.comparingInt((Node node) -> node.age)
                      .thenComparingInt(node -> node.seq)
        );
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.add(new Node(age, i, name));
        }
        while(!pq.isEmpty()){
            Node node = pq.poll();
            System.out.println(node.age + " " + node.name);
        }
    }
}
class Node{
    int age;
    int seq;
    String name;
    
    public Node(int age, int seq, String name){
        this.age = age;
        this.seq = seq;
        this.name = name;
    }
}