import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> coordinates = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
        for(int i = 0; i < N; i++) {
            coordinates.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> sortedCoordinates = new ArrayList<>(
                coordinates.stream()
                        .sorted()
                        .collect(Collectors.toUnmodifiableList())
        );

        Map<Integer, Integer> rankMap = new HashMap<>();

        int rank = 0;
        for (int coordinate : sortedCoordinates) {
            if (!rankMap.containsKey(coordinate)) {
                rankMap.put(coordinate, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int coordinate : coordinates) {
            int ranking = rankMap.get(coordinate);
            sb.append(ranking).append(SPACE);
        }

        System.out.print(sb);
    }
}
