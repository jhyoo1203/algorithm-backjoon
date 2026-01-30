import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        if (k > c * r) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[c + 1][r + 1];

        int x = 1;
        int y = 1;
        int dir = 0;

        visited[1][1] = true;

        for (int i = 0; i < k - 1; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || nx > c || ny < 1 || ny > r || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
            visited[x][y] = true;
        }

        System.out.println(x + " " + y);
    }
}
