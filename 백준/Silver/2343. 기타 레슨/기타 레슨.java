
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lessons = new int[n];

        int min = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            max += lessons[i];
            min = Math.max(min, lessons[i]);
        }


        while (min <= max) {
            int mid = (min + max) / 2;

            int count = getCount(n, lessons, mid);

            if (count > m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min);

    }

    static int getCount(int n, int[] lessons, int mid) {
        int sum = 0;
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (sum + lessons[i] > mid) { // 새로운 블루레이가 필요한 상황
                sum = 0;
                count++;
            }
            sum += lessons[i];
        }
        return count;
    }
}