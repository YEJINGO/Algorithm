import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] s = br.readLine().split(" ");
            if (Objects.equals(s[0], "0") && Objects.equals(s[1], "0"))
                break;
            Map<Integer, Integer> map = new TreeMap<>();


            for (int i = 0; i < Integer.parseInt(s[0]); i++) {
                String[] s1 = br.readLine().split(" ");
                for (int j = 0; j < Integer.parseInt(s[1]); j++) {
                    map.put(Integer.parseInt(s1[j]), map.getOrDefault(Integer.parseInt(s1[j]), 0) + 1);
                }
            }
            int maxValue = 0;
            int maxKey = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            map.remove(maxKey);

            int maxValue2 = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue2) {
                    maxValue2 = entry.getValue();
                }
            }


            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue2) {
                    System.out.print(entry.getKey() + " ");
                }
            }
            System.out.println();
        }
    }
}