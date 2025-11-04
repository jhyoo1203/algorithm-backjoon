import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[m];
        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int v : graph) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            graph[depth] = i + 1;
            dfs(depth + 1, i + 1);
        }
    }
}
