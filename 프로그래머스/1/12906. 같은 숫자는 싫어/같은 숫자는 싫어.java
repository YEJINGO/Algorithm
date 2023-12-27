

import java.util.*;

public class Solution {
    public Stack<Integer> solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if (stack.peek() == arr[i]) {
                    continue;
                } else {
                    stack.push(arr[i]);
                }
            }
        }

        return stack;
    }
}

