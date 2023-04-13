import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for (int i = 1; i <= Integer.parseInt(s[0]); i++) {
            String name = br.readLine();
            map.put(name, i);
            map2.put(i, name);
        }

        for (int i = 0; i < Integer.parseInt(s[1]); i++) {
            String answer = br.readLine();
            if (isNum(answer)) { // answer(String) -> Integer.parseINt
                sb.append(map2.get(Integer.parseInt(answer))).append("\n");
            } else {
                sb.append(map.get(answer)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}