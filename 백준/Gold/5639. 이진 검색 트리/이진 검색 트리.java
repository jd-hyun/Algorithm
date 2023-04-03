import java.io.*;
import java.util.*;

public class Main {
    static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("")) break;
            int value = Integer.parseInt(line);
            Node node = new Node(value, null, null);
            insertNode(node);
        }
        postOrder(root);
    }

    private static void insertNode(Node node) {
        if (root == null) {
            root = node;
        } else
        {
            Node temp = root;
            while (true) {
                if (temp.value > node.value) {
                    if (temp.left == null) {
                        temp.left = node;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = node;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}