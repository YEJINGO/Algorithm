import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 배열의 크기는 최댓값, 최솟값인 2로 설정한다. 
        int[] answer = new int[2];
        
        ArrayList<Integer> store = new ArrayList();
        // 최댓값
        PriorityQueue<Integer> maxQueue = new PriorityQueue(Collections.reverseOrder());
        // 최솟값
        PriorityQueue<Integer> minQueue = new PriorityQueue();
        
        for(String operation : operations){
            String[] ops = operation.split(" ");
            int num = Integer.parseInt(ops[1]);
            if(ops[0].equals("I")){
               // I 연산인 경우 최댓값과 최솟값을 저장하는 우선순위 큐에 값을 추가하고, store에도 값을 추가
                maxQueue.add(num);
                minQueue.add(num);
            }else{
                if(num == -1)
                    maxQueue.remove(minQueue.poll());
                else 
                    minQueue.remove(maxQueue.poll());
            }
        }
        
        answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.peek();
        answer[1] = minQueue.isEmpty() ? 0 : minQueue.peek();
        return answer;
    }
}