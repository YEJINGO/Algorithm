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
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i));
        }
        Collections.sort(list);
        for (String lists : list) {
            System.out.println(lists);
        }
    }
}