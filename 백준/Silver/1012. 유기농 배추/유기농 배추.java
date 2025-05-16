import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            int count = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int j, int k) {
        queue.add(new int[]{j, k});

        visited[j][k] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[1];
            int y = tmp[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && graph[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }

            }
        }
    }
}
