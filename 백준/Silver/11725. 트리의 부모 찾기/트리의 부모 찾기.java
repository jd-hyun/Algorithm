import java.util.*;

class Node {
    int value;
    List<Node> children;

    Node() {
        this.value = 0;
        this.children = new ArrayList<>();
    }
    Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}

public class Main {
    static int[] parents;
    static boolean[] isVisited;

    public static void findParents(Node root) {
        if (root == null) return;
        isVisited[root.value] = true;
        for (Node child : root.children) {
            if (!isVisited[child.value]) {
                parents[child.value] = root.value; // 자식의 부모를 현재 노드로 설정
                findParents(child); // 재귀적으로 자식의 자식들의 부모 찾기
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 노드의 개수

        // 노드 생성
        Node[] nodes = new Node[N + 1]; // 인덱스 1부터 사용하기 위해 크기를 N+1로 설정
        isVisited = new boolean[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        // 간선 정보 입력 및 트리 구성
        for (int i = 0; i < N - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            nodes[u].children.add(nodes[v]);
            nodes[v].children.add(nodes[u]);
        }

        findParents(nodes[1]); // 루트 노드를 1로 가정하여 부모 찾기

        // 각 노드의 부모를 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }
}