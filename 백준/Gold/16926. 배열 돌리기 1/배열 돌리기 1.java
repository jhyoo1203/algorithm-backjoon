import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groups = Math.min(n, m) / 2;

        for (int k = 0; k < r; k++) {

            for (int layer = 0; layer < groups; layer++) {

                int temp = arr[layer][layer];

                for (int i = layer; i < m - 1 - layer; i++) {
                    arr[layer][i] = arr[layer][i + 1];
                }

                for (int i = layer; i < n - 1 - layer; i++) {
                    arr[i][m - 1 - layer] = arr[i + 1][m - 1 - layer];
                }

                for (int i = m - 1 - layer; i > layer; i--) {
                    arr[n - 1 - layer][i] = arr[n - 1 - layer][i - 1];
                }

                for (int i = n - 1 - layer; i > layer; i--) {
                    arr[i][layer] = arr[i - 1][layer];
                }

                arr[layer + 1][layer] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
