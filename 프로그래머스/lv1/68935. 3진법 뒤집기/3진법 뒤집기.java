import java.util.ArrayList;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 0;
        ArrayList<Integer> list = new ArrayList<>();

        // 3진법 만들기
        while (n > 0) {
            list.add(n % 3);
            n /= 3;
        }
        int pow = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            answer += list.get(i) * Math.pow(3, pow++);
        }
        return answer;
    }
}