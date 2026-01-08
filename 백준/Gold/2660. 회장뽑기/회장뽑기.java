import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int[] scores = new int[n + 1];
        int minScore = INF;

        for (int i = 1; i <= n; i++) {
            int maxDist = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j && dist[i][j] != INF) {
                    maxDist = Math.max(maxDist, dist[i][j]);
                }
            }
            scores[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        System.out.println(minScore + " " + candidates.size());
        for (int candidate : candidates) {
            System.out.print(candidate + " ");
        }
    }
}
