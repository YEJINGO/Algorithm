import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 아이들과 거점지를 방문한 횟수
        StringBuilder sb = new StringBuilder(); // 결과를 담을 sb

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x); // 우선순위를 내림차순으로 만들기1
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }

//            System.out.println("st = " + st);
//            System.out.println("pq = " + pq);

            if (a != 0) { // 거점지일 경우
                continue;
            }

            // 아이들 만났을 때
            if (!pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}
