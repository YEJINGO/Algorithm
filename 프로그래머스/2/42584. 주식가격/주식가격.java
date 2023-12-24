import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int time = 0;
            int price = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                if (price <= prices[j]) {
                    time++;
                } else {
                    time++;
                    break; // 가격이 떨어지면 루프 종료
                }
            }

            answer[i] = time;
        }
        return answer;
    }
}