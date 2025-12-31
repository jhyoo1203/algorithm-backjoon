import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int problemCount = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra(n);
            sb.append("Problem ").append(problemCount++)
                    .append(": ")
                    .append(result).append("\n");
        }

        System.out.print(sb);
    }

    private static int dijkstra(int n) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = graph[0][0];
        pq.offer(new Node(0, 0, graph[0][0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.x == n - 1 && current.y == n - 1) {
                return current.cost;
            }

            if (current.cost > dist[current.x][current.y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int newCost = current.cost + graph[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        return dist[n - 1][n - 1];
    }
}
