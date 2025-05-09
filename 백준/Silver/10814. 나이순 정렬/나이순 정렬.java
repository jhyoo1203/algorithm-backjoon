import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<String>> memberMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            memberMap.computeIfAbsent(Integer.parseInt(st.nextToken()), k -> new ArrayList<>()).add(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<String>> entry : memberMap.entrySet()) {
            for (String name : entry.getValue()) {
                sb.append(entry.getKey()).append(" ").append(name).append("\n");
            }
        }
        System.out.print(sb);
    }
}
