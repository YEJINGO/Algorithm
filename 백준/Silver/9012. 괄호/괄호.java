import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 문자 받기 (Scanner)
        StringBuilder sb = new StringBuilder(); // 출력할 값 받기

        int T = Integer.parseInt(br.readLine()); // 총 몇번 값을 출력할 건지 정의

        for (int i = 0; i < T; i++) { // T번 만큼 for문을 돌려줌
            sb.append(way(br.readLine())).append('\n');

        }
        System.out.println(sb);
    }

    public static String way(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == ')') {
                if (stack.empty()) // empty 는 공백도 false 로 판단
                    return "NO";
                else
                    stack.pop();
            }
        }
        if (stack.empty())
            return "YES";
        else
            return "NO";
    }
}
