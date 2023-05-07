import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] tip = new Integer[N];
        for (int i = 0; i < N; i++) {
            tip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tip, Comparator.reverseOrder()); // 배열을 내림차순으로 정렬.

        long realTip = 0;

        for (int i = 0; i < N; i++) {
            int tempTip = tip[i] - (i);
            if (tempTip >= 0) {
                realTip += tempTip;
            }
        }
        System.out.println(realTip);

    }
}