
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int count = 99;

        if (n <= 99) {
            count = n;

        } else {
            int d = n - 100;
            for (int i = n - d; i <= n; i++) {
                int first = i / 100;
                int second = (i / 10) % 10;
                int third = i % 10;
                if (second - first == third - second) {
                    count++;
                }
            }
        }
        System.out.println(sb.append(count));
    }
}