class Solution {
    public int[] solution(long n) {


        // int 자리수 구하기 : (int)( Math.log10(num)+1 )
        int length = (int)(Math.log10(n) + 1); // n 길이 구하기
        int[] answer = new int[length];

        while (n > 0) {
            for (int i = 0; i < length; i++) {
                answer[i] = (int) (n % 10);
                n /= 10;
            }
        }
        return answer;
    }
}
