import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            sb = new StringBuilder(String.valueOf(s.charAt(i)));
            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
            }
            list.add(String.valueOf(sb));
        }
        Collections.sort(list);
        for (String lists : list) {
            System.out.println(lists);
        }
    }
}
