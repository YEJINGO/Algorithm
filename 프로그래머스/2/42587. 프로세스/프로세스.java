import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Integer> prioritiesQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        int count = 0;

        // 가장 큰 수 추출하기
        Queue<Integer> maxPriorityQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < priorities.length; i++) {
            prioritiesQueue.add(priorities[i]);
            indexQueue.add(i);
            maxPriorityQueue.add(priorities[i]);
        }

        while (!prioritiesQueue.isEmpty()) {
            int max = maxPriorityQueue.peek();
            Integer prioritiesPoll = prioritiesQueue.poll();
            Integer indexPoll = indexQueue.poll();

            if (max == prioritiesPoll) {
                count += 1;
                maxPriorityQueue.poll();
                if (indexPoll == location) {
                    break;
                }

            } else {
                prioritiesQueue.add(prioritiesPoll);
                indexQueue.add(indexPoll);
            }
        }

        return count;
    }
}