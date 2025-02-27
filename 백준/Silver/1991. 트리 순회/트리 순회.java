import java.util.*;
import java.io.*;
class Main{
    static BinaryTree tree = new BinaryTree();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            tree.addNode(st.nextToken(), st.nextToken(),st.nextToken());
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}
class BinaryTree{
    Node root;

    public void addNode(String parent, String left, String right){
        if(root == null){ //루트 노드 설정
            root = new Node(parent);
        }
        add(root, parent, left, right);
    }

    private void add(Node current, String parent, String left, String right){
        if(current == null) return;
        if(current.data.equals(parent)){
            if(!left.equals(".")) current.left = new Node(left);
            if(!right.equals(".")) current.right = new Node(right);
        }else {
            add(current.left, parent, left, right);
            add(current.right, parent, left, right);
        }
    }

    //전위 순회
    // root left right
    public void preorder(Node node){
        if(node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    //중위 순회
    // left root right
    public void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    //후위 순회
    // left right root
    public void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}
class Node{
    String data; //현재 노드 값
    Node left; //왼쪽 자식 노드
    Node right; //오른쪽 자식 노드

    public Node(String data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}