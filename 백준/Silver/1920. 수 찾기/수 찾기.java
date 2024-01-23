import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

//        System.out.println("nums = " + Arrays.toString(nums));

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] findNums = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            findNums[i] = Integer.parseInt(st.nextToken());
            if (map.containsKey(findNums[i])) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
//        System.out.println("findNums = " + Arrays.toString(findNums));

        System.out.println(sb);
    }
}