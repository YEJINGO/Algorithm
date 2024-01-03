import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        // 가로길이는 3이상이 되어야 하기 때문에 i=3으로 설정한다.
        for (int i = 3; i < total; i++) {
            // j는 세로 길이를 의미한다.
            int j = total / i;
            if (total % i == 0 && j >= 3) {
                // col : 가로길이로, 세로보다 크기 때문에 max값을 찾는다.
                // row : 세로길이로, 가로보다 작기 때문에 min값을 찾는다.
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                // 위에서 나온 가로,세로 길이로 가운데 노란색 타일 길이를 구한다. 
                int centerYellow = (col - 2) * (row - 2);

                if (centerYellow == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}