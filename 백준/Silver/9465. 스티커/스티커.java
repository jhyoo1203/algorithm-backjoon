import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][n];
            dp[0][0] = sticker[0][0]; // 위쪽 선택
            dp[1][0] = sticker[1][0]; // 아래쪽 선택
            dp[2][0] = 0; // 선택 안 함

            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + sticker[1][i];
                dp[2][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1]);
            }

            int result = Math.max(Math.max(dp[0][n - 1], dp[1][n - 1]), dp[2][n - 1]);
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
