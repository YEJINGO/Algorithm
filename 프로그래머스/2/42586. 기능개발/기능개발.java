import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
  Queue<Integer> days = new LinkedList<>();
  List<Integer> answerList = new ArrayList<>(); // 배열 대신 리스트를 사용

        int[] answer = {};


        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            days.add(day);
        }

        int count = 1; // 배포되는 기능의 개수를 세는 변수

        while (!days.isEmpty()) {
            int current = days.poll(); // 가장 앞의 기능 개발일을 가져옴

            // 뒤에 있는 기능이 더 빨리 개발되면 count를 증가시키고 계속해서 다음 기능 검사
            while (!days.isEmpty() && current >= days.peek()) {
                days.poll();
                count++;
            }

            answerList.add(count); // 현재까지 배포되는 기능의 개수를 리스트에 추가
            count = 1; // 초기화
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
    }
                return answer;
    }
}