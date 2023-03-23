import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 0;

        while (n > 0) {
            a = n % 10;
            n /= 10;
            answer += a;

        }
        return answer;
    }
}