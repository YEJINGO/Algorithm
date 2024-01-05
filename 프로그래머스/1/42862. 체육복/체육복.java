import java.util.Arrays;


class Solution {
    // [1,1,1,1,1]
    // [1,0,1,0,1]
    // [2,0,2,0,2]

    public int solution(int n, int[] lost, int[] reserve) {
        int[] uniform = new int[n];
        int count = 0;
        // 모든 값을 1로 채운다.
        Arrays.fill(uniform, 1);

        for (int k : lost) {
            int lostValue = k - 1;
            uniform[lostValue] = uniform[lostValue] - 1;
        }

        for (int j : reserve) {
            int reserveValue = j - 1;
            uniform[reserveValue] = uniform[reserveValue] + 1;

        }

        for (int i = 0; i < uniform.length; i++) {
            // 해당값이 0일 때, 
            if (uniform[i] == 0) {
                // 인덱스가 0일 때
                if (i == 0) {
                    // 맨 앞에 값이 0일땐 오른쪽에서 가져오기
                    if (uniform[i + 1] == 2) {
                        uniform[i] += 1;
                        uniform[i + 1] -= 1;
                    }
                    // 맨 뒷 값이 0일땐 왼쪽에서 가져오기 
                } else if (i == uniform.length - 1) {
                    if (uniform[i - 1] == 2) {
                        uniform[i] += 1;
                        uniform[i - 1] -= 1;
                    }
                } else {
                    // 중간 값들                                
                    if (uniform[i - 1] == 2) {
                        uniform[i] += 1;
                        uniform[i - 1] -= 1;
                    } else if (uniform[i + 1] == 2) {
                        uniform[i] += 1;
                        uniform[i + 1] -= 1;
                    }
                }
            }
        }
        for (int j : uniform) {
            if (j >= 1) {
                count++;
            }
        }

        return count;
    }
}