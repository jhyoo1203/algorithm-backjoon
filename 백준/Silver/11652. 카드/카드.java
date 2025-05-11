import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long key = Long.parseLong(br.readLine());
            cardMap.merge(key, 1, Integer::sum);
        }

        int maxCount = cardMap.values().stream()
                .max(Integer::compare)
                .orElse(0);

        long result = cardMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .min(Long::compare)
                .orElse(0L);

        System.out.println(result);
    }
}
