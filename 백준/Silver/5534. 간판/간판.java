import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 처음 받는 수
        String[] newName = br.readLine().split("");
        int newNameLength = newName.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            String oldName = br.readLine();
            Map<String, List<Integer>> map = new HashMap<>();
            for (int j = 0; j < oldName.length(); j++) {

                String c = String.valueOf(oldName.charAt(j));
                List<Integer> tmp = new ArrayList<>();
                if (map.containsKey(c)) {
                    tmp = map.get(c);
                }
                tmp.add(j);
                map.put(c, tmp);
            }

            if(!isContained(newName, map)) continue;

            if (isValid(newName, newNameLength, map)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isContained(String[] newName, Map<String, List<Integer>> map) {
        for (String c: newName) {
            if (!map.containsKey(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(String[] newName, int newNameLength, Map<String, List<Integer>> map) {
        List<Integer> first = map.get(newName[0]);
        List<Integer> last = map.get(newName[newName.length - 1]);

        for (Integer f : first) {
            for (Integer l : last) {
                if (f > l && l - f <= newNameLength - 2) continue;
                int distance = l - f;
                if (distance % (newNameLength - 1) > 0) continue;
                int nextIdx = distance / (newNameLength - 1);
                boolean check = true;
                for (int j = 1; j < newNameLength - 1; j++) {
                    int targetIdx = f + (j * nextIdx);
                    if (!map.get(newName[j]).contains(targetIdx)) {
                        check = false;
                        break;
                    }
                }
                if (check) return true;
            }
        }
        return false;
    }
}

