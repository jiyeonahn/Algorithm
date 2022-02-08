import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    String data;
    Node left;
    Node right;

    Node(String data) {
        this.data = data;
    }
}

class Tree {
    public static Node root;

    public static void AddNode(String data, String left, String right) {
        if (root == null) {
            root = new Node(data);
            if (!left.equals(".")) {
                root.left = new Node(left);
            }
            if (!right.equals(".")) {
                root.right = new Node(right);
            }
        } else {
            searchNode(root, data, left, right);
        }
    }

    public static void searchNode(Node root, String data, String left, String right) {
        if (root == null) return;
        if (root.data.equals(data)) {
            if (!left.equals(".")) {
                root.left = new Node(left);
            }
            if (!right.equals(".")) {
                root.right = new Node(right);
            }
        } else {
            searchNode(root.left, data, left, right);
            searchNode(root.right, data, left, right);
        }
    }

    public static void preOrder(Node root) {
        System.out.print(root.data);
        if(root.left != null) preOrder(root.left);
        if(root.right != null) preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root.left != null) inOrder(root.left);
        System.out.print(root.data);
        if(root.right != null) inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root.left != null) postOrder(root.left);
        if(root.right != null) postOrder(root.right);
        System.out.print(root.data);
    }

}

public class boj1991 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Tree.AddNode(st.nextToken(), st.nextToken(), st.nextToken());
        }

        Tree.preOrder(Tree.root);
        System.out.println();
        Tree.inOrder(Tree.root);
        System.out.println();
        Tree.postOrder(Tree.root);

    }

}