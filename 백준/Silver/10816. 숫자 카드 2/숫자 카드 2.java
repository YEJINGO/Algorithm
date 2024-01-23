import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            map.put(num[i], map.getOrDefault(num[i], 0) + 1);
        }
//        System.out.println("num = " + Arrays.toString(num));
//        System.out.println("map = " + map);

        st = new StringTokenizer(br.readLine());
        int pickNum = Integer.parseInt(st.nextToken());

        int[] pickCards = new int[pickNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pickNum; i++) {
            pickCards[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println("pickCards = " + Arrays.toString(pickCards));

        for (int pickCard : pickCards) {
            sb.append(map.getOrDefault(pickCard, 0));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}