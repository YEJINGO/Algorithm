import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[][] values = new int[n][2];  // 2차원 배열 선언
        int count = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            values[i][0] = Integer.parseInt(st.nextToken());
            values[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < values.length; i++) {
            int i1 = values[i][0];
            int i2 = values[i][1];
            for (int j = values.length - 1; j >= 0; j--) {
                int i3 = values[j][0];
                int i4 = values[j][1];
                if (i1 < i3 && i2 < i4) {
                    count++;
                }
            }
            sb.append(count).append(" ");
            count = 1;

        }
        System.out.println(sb);
    }
}
