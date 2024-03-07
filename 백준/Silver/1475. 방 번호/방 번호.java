import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String nums = st.nextToken();
        int max = 0;

        int[] arr = new int[10];
        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) - '0' == 6) {
                arr[9]++;
            } else {
                arr[nums.charAt(i) - '0']++;
            }
        }
        /**
         * 9번째 홀수인지 짝수인지 판별해서 값을 넣어준다.
         * 그런데 9번째 값 자체에서 1을 더해주고 몫을 구하면 홀수/짝수를 나누지 않아도된다.
         */
        arr[9] = (arr[9] + 1) / 2;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
