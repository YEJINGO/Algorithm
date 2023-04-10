import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> list = new ArrayList<>();

        while (n > 0) { // 각 자리수를 구해서 list에 추가
            list.add(n % 10);
            n /= 10;
        }

        Collections.sort(list, Collections.reverseOrder()); // 내림차순으로 정렬

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        answer = Long.parseLong(sb.toString()); // 문자열을 long 타입으로 변환
        return answer;
    }
}
