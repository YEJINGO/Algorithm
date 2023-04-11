import java.util.ArrayList;


class Solution {
        public int[] solution(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (min != arr[i]) {
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        if (answer.length == 0) {
            return new int[]{-1};
        }
        return answer;
    }
}