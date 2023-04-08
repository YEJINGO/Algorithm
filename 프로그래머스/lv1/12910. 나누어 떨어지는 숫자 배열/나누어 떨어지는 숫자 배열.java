import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] answer = {};
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0)
                list.add(arr[i]);
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer); 
        return answer;

    }
}