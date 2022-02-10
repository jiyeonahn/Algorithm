import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2205 {//트리의 높이와 너비
    private static int root, colindex = 1;
    private static Node[] node;
    private static int[] min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        min = new int[N+1];
        max = new int[N+1];
        node = new Node[N+1];

        for(int i = 1; i <= N; i++){
            min[i] = N;
            node[i] = new Node(i,-1,-1);
        }

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            node[n].left = l;
            node[n].right = r;

            if(l != -1) node[l].parent = n;
            if(r != -1) node[r].parent = n;
        }

        for(int i = 1; i <= N; i++){
            if(node[i].parent == -1){
                root = i;
                break;
            }
        }

        inorder(root, 1);

        int answer = 0;
        for(int i = 1; i <= N; i++){
            answer = Math.max(answer, max[i] - min[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(answer == max[i] - min[i]){
                sb.append(i).append(" ").append(answer+1);
                break;
            }
        }
        System.out.println(sb.toString());
    }

    private static void inorder(int parent, int level){
        if(node[parent].left != -1){
            inorder(node[parent].left, level+1);
        }
        min[level] = Math.min(min[level], colindex);
        max[level] = Math.max(max[level], colindex);
        colindex++;//중위 순회의 순서
        if(node[parent].right != -1){
            inorder(node[parent].right, level + 1);
        }
    }

    static class Node{
        int parent;
        int value;
        int left;
        int right;
        public Node(int value, int left, int right){
            this.parent = -1;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
