import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[36];
        a[0] = 1L;
        a[1] = 1L;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                a[i] += a[j] * a[i - j - 1];
            }
        }
        System.out.println(a[n]);
    }
}
