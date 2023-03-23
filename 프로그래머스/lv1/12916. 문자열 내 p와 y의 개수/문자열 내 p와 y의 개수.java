class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int y = 0;
        int q = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                y++;
            } else if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                q++;
            }
        }

        if (y == q)
            return true;
        return false;
    }
}
