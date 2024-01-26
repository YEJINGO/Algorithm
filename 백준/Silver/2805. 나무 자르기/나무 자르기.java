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

        int max = 0; 

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            int treeHeight = Integer.parseInt(st.nextToken());
            trees[i] = treeHeight;
            max = Math.max(max, trees[i]);
        }

        int lo = 0;
        int hi =max;
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
//                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(hi);
    }
}