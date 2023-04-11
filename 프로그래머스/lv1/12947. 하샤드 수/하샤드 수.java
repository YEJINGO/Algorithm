class Solution {
    public boolean solution(int x) {
        int a = 0;
        
        int temp = x;
        while (temp > 0) {
            a += temp % 10;
            temp /= 10;
        }


        if (x % a == 0) {
            return true;
        } else {
            return false;
        }
    }
}
