import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final char[][] tree = new char[26][2]; // [노드][0:왼쪽, 1:오른쪽]
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[parent - 'A'][0] = left;
            tree[parent - 'A'][1] = right;
        }

        preorder('A');
        sb.append('\n');
        inorder('A');
        sb.append('\n');
        postorder('A');

        System.out.println(sb);
    }

    // 전위 순회: 루트 → 왼쪽 → 오른쪽
    static void preorder(char node) {
        if (node == '.') return;

        sb.append(node);
        preorder(tree[node - 'A'][0]);
        preorder(tree[node - 'A'][1]);
    }

    // 중위 순회: 왼쪽 → 루트 → 오른쪽
    static void inorder(char node) {
        if (node == '.') return;

        inorder(tree[node - 'A'][0]);
        sb.append(node);
        inorder(tree[node - 'A'][1]);
    }

    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    static void postorder(char node) {
        if (node == '.') return;

        postorder(tree[node - 'A'][0]);
        postorder(tree[node - 'A'][1]);
        sb.append(node);
    }
}
