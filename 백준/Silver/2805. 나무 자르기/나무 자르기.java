import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nmToken = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nmToken.nextToken());
        int m = Integer.parseInt(nmToken.nextToken());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            int treeHeight = Integer.parseInt(st.nextToken());
            trees[i] = treeHeight;
        }
        Arrays.sort(trees);

        int lo = 0;
        int hi = trees[n - 1]; // 최대 높이의 나무를 기준으로 시작
        int answer = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            long sum = 0; // int 형의 범위를 벗어날 수 있으므로 long으로 변경

            for (int i = 0; i < n; i++) {
                int cutHeight = trees[i] - mid;
                if (cutHeight > 0) {
                    sum += cutHeight;
                }
            }

            if (sum >= m) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(answer);
    }
}