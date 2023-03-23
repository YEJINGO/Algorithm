class Solution {
    public int[] solution(long n) {

        int length = (int) (Math.log10(n) + 1);
        int[] answer = new int[length];

        while (n > 0) {
            for (int i = 0; i < length; i++) {
                answer[i] += n % 10;
                n /= 10;
            }
        }
        return answer;
    }
}
