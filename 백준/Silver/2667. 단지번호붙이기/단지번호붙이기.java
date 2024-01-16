import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        boolean[][] visited = new boolean[n + 1][n + 1];
        ArrayList<Integer> allHouseCnt = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int num = arr[i][j];

                int houseCount = 0;
                if (num == 1 && !visited[i][j]) {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] pop = stack.pop();
                        int firstPop = pop[0];
                        int secondPop = pop[1];
                        if (visited[firstPop][secondPop]) {
                            continue;

                        }
                        visited[firstPop][secondPop] = true;
                        houseCount++;

                        for (int k = 0; k < 4; k++) {
                            int dx = x[k];
                            int dy = y[k];
                            if (firstPop + dx >= 0 && firstPop + dx < n) {
                                if (secondPop + dy >= 0 && secondPop + dy < n) {
                                    if (!visited[firstPop + dx][secondPop + dy] && arr[firstPop + dx][secondPop + dy] == 1) {

                                        stack.push(new int[]{firstPop + dx, secondPop + dy});

                                    }
                                }
                            }
                        }
                    }
                    allHouseCnt.add(houseCount);
                }
            }
            Collections.sort(allHouseCnt);
        }
        System.out.println(allHouseCnt.size());
        for (Integer integer : allHouseCnt) {
            System.out.println(integer);
        }
    }
}
