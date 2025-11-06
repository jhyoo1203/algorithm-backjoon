import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] min = new int[n][3];
        int[][] max = new int[n][3];

        for (int i = 0; i < 3; i++) {
            min[0][i] = arr[0][i];
            max[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    min[i][j] = Math.min(min[i - 1][j], min[i - 1][j + 1]) + arr[i][j];
                    max[i][j] = Math.max(max[i - 1][j], max[i - 1][j + 1]) + arr[i][j];
                } else if (j == 1) {
                    min[i][j] = Math.min(min[i - 1][j - 1], Math.min(min[i - 1][j], min[i - 1][j + 1])) + arr[i][j];
                    max[i][j] = Math.max(max[i - 1][j - 1], Math.max(max[i - 1][j], max[i - 1][j + 1])) + arr[i][j];
                } else {
                    min[i][j] = Math.min(min[i - 1][j - 1], min[i - 1][j]) + arr[i][j];
                    max[i][j] = Math.max(max[i - 1][j - 1], max[i - 1][j]) + arr[i][j];
                }
            }
        }

        int maxVal = Arrays.stream(max[n - 1]).max().getAsInt();
        int minVal = Arrays.stream(min[n - 1]).min().getAsInt();
        System.out.println(maxVal + " " + minVal);
    }
}
