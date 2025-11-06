import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int m;
    private static final List<Point> houses = new ArrayList<>();
    private static final List<Point> chickens = new ArrayList<>();
    private static final List<Point> selected = new ArrayList<>();
    private static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new Point(i, j));
                } else if (value == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        backtrack(0, 0);
        System.out.println(minDistance);
    }

    private static void backtrack(int idx, int count) {
        // M개를 모두 선택한 경우
        if (count == m) {
            int cityDistance = calculateDistance();
            minDistance = Math.min(minDistance, cityDistance);
            return;
        }

        // 남은 치킨집으로 M개를 채울 수 없는 경우 (가지치기)
        if (idx == chickens.size()) {
            return;
        }

        // 현재 치킨집 선택
        selected.add(chickens.get(idx));
        backtrack(idx + 1, count + 1);
        selected.remove(selected.size() - 1);

        // 현재 치킨집 선택 안함
        backtrack(idx + 1, count);
    }

    private static int calculateDistance() {
        int sum = 0;

        for (Point house : houses) {
            int minDist = Integer.MAX_VALUE;
            for (Point chicken : selected) {
                int dist = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }

        return sum;
    }
}
