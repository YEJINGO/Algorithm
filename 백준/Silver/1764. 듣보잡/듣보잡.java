import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] n = br.readLine().split(" ");

        Map<String, Integer> person = new TreeMap<>();
        for (int i = 0; i < Integer.parseInt(n[0]); i++) {
            String s = br.readLine();
            person.put(s, person.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < Integer.parseInt(n[1]); i++) {
            String s = br.readLine();
            person.put(s, person.getOrDefault(s, 0) + 1);
        }

        List<String> count = new ArrayList();
        for (Map.Entry<String, Integer> entry : person.entrySet()) {
            if (entry.getValue() == 2) {
                count.add(entry.getKey());
                sb.append(entry.getKey()).append("\n");
            }
        }
        System.out.println(count.size());
        System.out.println(sb);
    }
}