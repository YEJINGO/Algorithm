import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] snacks = new int[n];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snacks[i]);
        }
       // System.out.println("snacks = " + Arrays.toString(snacks));
        int result = 0; // 나누어주는 과자의 길이
        int left = 1;
        int right = max;

        while (left <= right) {
            int count = 0; // 나누어 줄 수 있는 조카의 수
            int mid = (left + right) / 2;

            for (int i = 0; i < n; i++) {
                count += snacks[i] / mid;
            }

            if (count >= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        System.out.println (result);
    }
}