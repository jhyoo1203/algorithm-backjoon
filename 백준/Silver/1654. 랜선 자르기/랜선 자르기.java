import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = Arrays.stream(arr).max().getAsInt();
        long result = 0;

        while (start <= end) {
            long count = 0;
            long mid = (start + end) / 2;

            for (int a : arr) {
                count += (a / mid);
            }

            if (count < n) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
