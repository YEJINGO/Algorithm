import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int max = 0;
        int end = 0;

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            max = Math.max(max, arr[i]);
        }

        // 자신이 가지고 있는 돈 중에 가장 큰 금액이 최소 금액이 된다. 그래야 돈을 가장 많이 쓴 날의 금액을 인출할 수 있기 때문이다.
        int start = max;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (m >= withdrawalCount(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;

            }
        }
        System.out.println(result);
    }

    static int withdrawalCount(int mid) {
        int count = 1;
        int money = mid;

        for (int i = 0; i < arr.length; i++) {
            if (money < arr[i]) {
                money = mid;
                count++;
            }
            money -= arr[i];

        }
        return count;
    }
}
