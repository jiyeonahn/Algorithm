import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            // 모든 점수가 같으면 이름이 사전 순
            if(n1.k == n2.k && n1.e == n2.e && n1.m == n2.m){
                return n1.name.compareTo(n2.name); 
            }
            // 국어 점수와 영어 점수가 같으면 수학 점수 내림차순
            if(n1.k == n2.k && n1.e == n2.e){
                return n2.m - n1.m;
            }
            // 국어 점수가 같으면 영어 점수 오름차순
            if(n1.k == n2.k){
                return n1.e - n2.e;
            }
            // 국어 점수 내림차순
            return n2.k - n1.k;
        });
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            pq.add(new Node(name, k, e, m));
        }
        while(!pq.isEmpty()){
            Node node = pq.poll();
            System.out.println(node.name);
        }
    }
}
class Node{
    String name;
    int k;
    int e;
    int m;
    
    public Node(String name, int k, int e, int m){
        this.name = name;
        this.k = k;
        this.e = e;
        this.m = m;
    }
}