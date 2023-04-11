import java.util.ArrayList;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};

        // lottos 를 list 에 담기
        ArrayList<Integer> lotto_numbers = new ArrayList<>();
        for (int i = 0; i < lottos.length; i++) {
            lotto_numbers.add(lottos[i]);
        }

        // win_numbers 를 list 에 담기
        ArrayList<Integer> win_numbers = new ArrayList<>();
        for (int i = 0; i < win_nums.length; i++) {
            win_numbers.add(win_nums[i]);
        }

        int num_0 = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto_numbers.get(i) == 0) num_0++;
        }

        int count = 0; // 일치하는 수 개수 찾기
        for (int i = 0; i < 6; i++) {
            if (win_numbers.contains(lotto_numbers.get(i)))
                count++;
        }

        int max = num_0 + count;
        int min = count;
        if (max == 6) max = 1;
        else if (max == 5) max = 2;
        else if (max == 4) max = 3;
        else if (max == 3) max = 4;
        else if (max == 2) max = 5;
        else max = 6;

        if (min == 6) min = 1;
        else if (min == 5) min = 2;
        else if (min == 4) min = 3;
        else if (min == 3) min = 4;
        else if (min == 2) min = 5;
        else min = 6;

        answer = new int[]{max, min};
        return answer;
    }
}