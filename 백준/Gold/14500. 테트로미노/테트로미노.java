import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int max = Integer.MIN_VALUE;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int n;
    private static int m;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, graph[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (!visited[nx][ny]) {
                if (count == 2) {
                    visited[nx][ny] = true;
                    dfs(x, y, sum + graph[nx][ny], count + 1);
                    visited[nx][ny] = false;
                }

                visited[nx][ny] = true;
                dfs(nx, ny, sum + graph[nx][ny], count + 1);
                visited[nx][ny] = false;
            }
        }
    }
}
