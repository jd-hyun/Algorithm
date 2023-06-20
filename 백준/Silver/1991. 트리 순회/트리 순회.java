import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;

    static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        root = makeNode(br);
        for (int i = 1; i < N; i++) {
            insertNode(root, makeNode(br));
        }

        prefix(root);
        System.out.println();
        suffix(root);
        System.out.println();
        postfix(root);
        System.out.println();
    }

    private static Node makeNode(BufferedReader br) throws IOException {
        String[] split = br.readLine().split(" ");
        Node left = split[1].equals(".") ? null : new Node(split[1], null, null);
        Node right = split[2].equals(".") ? null : new Node(split[2], null, null);
        return new Node(split[0], left, right);
    }

    private static void insertNode(Node root, Node newNode) {
        if (root == null) return;
        if (root.value.equals(newNode.value)) {
            root.left = newNode.left;
            root.right = newNode.right;
            return;
        }
        insertNode(root.left, newNode);
        insertNode(root.right, newNode);
    }

    private static void prefix(Node root) {
        if (root == null) return;
        System.out.print(root.value);
        prefix(root.left);
        prefix(root.right);
    }

    private static void suffix(Node root) {
        if (root == null) return;
        suffix(root.left);
        System.out.print(root.value);
        suffix(root.right);
    }

    private static void postfix(Node root) {
        if (root == null) return;
        postfix(root.left);
        postfix(root.right);
        System.out.print(root.value);
    }
}

class Node {
    String value;
    Node left;
    Node right;

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}