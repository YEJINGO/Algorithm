import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            for (int j = 0; j <= 0; j++) {
                int[] ints = Arrays.copyOfRange(array, commands[i][j]-1, commands[i][j + 1]);
                Arrays.sort(ints);
                answer[i] = ints[commands[i][j + 2] - 1];
            }
        }
        return answer;
    }
}