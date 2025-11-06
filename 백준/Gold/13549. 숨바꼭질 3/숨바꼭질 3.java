import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    private static int bfs(int start, int target) {
        if (start == target) return 0;

        int[] dist = new int[MAX + 1];
        boolean[] visited = new boolean[MAX + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();

            if (cur == target) return dist[cur];

            // 순간이동 (0초) - deque 앞에 추가
            int teleport = cur * 2;
            if (teleport <= MAX && !visited[teleport]) {
                visited[teleport] = true;
                dist[teleport] = dist[cur];
                deque.addFirst(teleport);
            }

            // 걷기 (1초) - deque 뒤에 추가
            int[] walks = {cur - 1, cur + 1};
            for (int next : walks) {
                if (next >= 0 && next <= MAX && !visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    deque.addLast(next);
                }
            }
        }

        return -1;
    }
}
