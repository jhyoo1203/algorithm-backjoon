import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[n + 1][n + 1][3];  // 0:가로, 1:세로, 2:대각
        dp[1][2][0] = 1;

        for (int r = 1; r <= n; r++) {
            for (int c = 2; c <= n; c++) {
                if (arr[r][c] == 1) continue;  // 벽

                // 가로
                if (c - 1 >= 1 && arr[r][c - 1] == 0) {
                    dp[r][c][0] += dp[r][c - 1][0] + dp[r][c - 1][2];
                }

                // 세로
                if (r - 1 >= 1 && arr[r - 1][c] == 0) {
                    dp[r][c][1] += dp[r - 1][c][1] + dp[r - 1][c][2];
                }

                // 대각선
                if (r - 1 >= 1 && c - 1 >= 1 && arr[r - 1][c] == 0 && arr[r][c - 1] == 0 && arr[r][c] == 0) {
                    dp[r][c][2] += dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
                }
            }
        }

        long result = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(result);
    }
}
