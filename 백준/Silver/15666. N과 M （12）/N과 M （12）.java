import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        comb(num, new int[m], 0, 0, n, m);
    }

    static void comb(int[] num, int[] output, int start, int depth, int n, int m) {


        if (depth == m) {
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        // prev 변수의 역할은 현재 깊이에서 이전에 선택된 원소를 기억하는 것

        int prev = -1;
        for (int i = start; i < n; i++) {
            if (prev != num[i]) {
                output[depth] = num[i];
                comb(num, output, i, depth + 1, n, m);
                prev = num[i];
            }
        }
    }
}
