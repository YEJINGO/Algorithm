class Solution {
public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int same_num = 0;

        // 뽑은 값과 결과가 몇개가 같은지 구한다 -> 최소 일때
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    same_num++;
                }
            }
        }
        // 0의 개수를 구한다.
        int max = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                max++;
            }
        }
        max = same_num + max; // 최대일때
        answer[0] = getGrade(max);
        answer[1] = getGrade(same_num);
        return answer;
    }

    public int getGrade(int n) {
        switch (n) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}