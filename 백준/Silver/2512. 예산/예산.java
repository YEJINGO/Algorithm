import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] budgets = new int[n];
        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int budget = Integer.parseInt(st.nextToken());
            budgets[i] = budget;
            max = Math.max(max, budgets[i]);
        }
        st = new StringTokenizer(br.readLine());
        int sumBudgets = Integer.parseInt(st.nextToken());

        //System.out.println("n = " + n);
        //System.out.println("budgets = " + Arrays.toString(budgets));
        //System.out.println("sumBudgets = " + sumBudgets);

        int answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 0;

//            for (int i = 0; i < n; i++) {
//                if (budgets[i] > mid) {
//                    answer += mid;
//                } else {
//                    answer += budgets[i];
//                }
            for (int i = 0; i < n; i++) {
                count += Math.min(budgets[i], mid);
            }

            //예산보다 주는 돈이 더 적거나 같은 경우 -> 더 넉넉하게 잡아도 된다는 뜻
            if (count <= sumBudgets) {
                answer = mid;
                min = mid + 1;
            } else { //예산보다 주는 돈이 더 큰 경우 -> 예산 총액 초과, 더 타이트하게 잡아야 한다는 뜻

                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

