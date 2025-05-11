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

        int maxCount = 0;
        long result = 0L;

        for (Map.Entry<Long, Integer> entry : cardMap.entrySet()) {
            long key = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                result = key;
            } else if (count == maxCount && key < result) {
                result = key;
            }
        }

        System.out.println(result);
    }
}
