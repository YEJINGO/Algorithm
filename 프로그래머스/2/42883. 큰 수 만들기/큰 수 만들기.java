import java.util.Stack;
                    
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < number.length(); i++) {
            int currentNum = number.charAt(i) - '0';
            while (k > 0 && !stack.isEmpty()) {
                int peek = stack.peek();

                if (peek < currentNum) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }
            stack.add(currentNum);
        }
        
         if (k > 0) {
            for (int i = 0; i < k; i++) {
                stack.pop();
            }
        }
        Object[] array = stack.toArray();
        for (Object o : array) {
            answer.append(o);
        }
        return answer.toString();
    }
}