class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int max1 = 0; // 가로
        int max2 = 0; // 높이

        for (int i = 0; i < sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            max1 = Math.max(max1, width);
            max2 = Math.max(max2, height);
        }
        return answer = max1 * max2;
    }
}