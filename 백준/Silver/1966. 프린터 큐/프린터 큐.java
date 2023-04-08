import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String[] a = br.readLine().split(" ");
            String[] b = br.readLine().split(" ");

            int M = Integer.parseInt(a[1]);
            Queue<Integer> que1 = new LinkedList<>();
            Queue<Integer> que2 = new LinkedList<>();

            for (int j = 0; j < Integer.parseInt(a[0]); j++) {
                que1.offer(Integer.valueOf(b[j])); // 값 빼내기
                que2.offer(j); // 인덱스값 빼내기
            }

            int count = 0;

            while (que1.size() > 0) {
                int p = que1.poll();
                int target = que2.poll();

                if (que1.size() == 0) {
                    count++;
                    break;
                }

                int max = Collections.max(que1);

                if (p >= max) {
                    count++;
                    if (target == M) {
                        break;
                    }
                } else {
                    que1.offer(p);
                    que2.offer(target);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}