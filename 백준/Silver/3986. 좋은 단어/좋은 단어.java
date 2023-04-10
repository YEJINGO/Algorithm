import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() % 2 != 0)
                continue;
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                Character c = s.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    Character p = stack.pop();
                    if (c != p) {
                        stack.push(p);
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty())
                cnt++;
        }
        System.out.println(cnt);
    }
}