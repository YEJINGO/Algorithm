import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); // 변수를 몇 개 받을 지 선언한다 (예제에서는 5를 의미함)
        String str = br.readLine(); // 계산할 식

        // 변수에 들어올 숫자들을 받아한다. A B C D E
        Map<Character, Double> subs = new HashMap<>();
        for (char c='A'; c<'A'+num; c++) { // 'A' + 5 = 'F'
            subs.put(c, Double.parseDouble(br.readLine())); // A, B, C, D, E의 값을 입력해주는 곳
        } // { A:1,B:2,C:3,D:4,E:5 }
        Stack<Double> stack = new Stack<>(); // Stack 라이브러리 사용

        for (int i = 0; i < str.length(); i++) {
            if (subs.containsKey(str.charAt(i))) { // str의 값이 subs(map)의 key를 포함하고 있다면, 그 key의 value를 가져옴
                stack.push(subs.get(str.charAt(i)));
            } else {

                double num2 = stack.pop(); // 뒤에 있는 값부터 계산해야하기 때문에 num2를 먼저 선언
                double num1 = stack.pop();

                switch (String.valueOf(str.charAt(i))) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        System.out.printf("%.2f",stack.pop()); // 결과를 소숫점 둘째 자리까지 출력
    }
}
