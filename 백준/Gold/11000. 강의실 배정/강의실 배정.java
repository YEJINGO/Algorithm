import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Time {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작 시간 저장
            int end = Integer.parseInt(st.nextToken()); // 종료 시간 저장
            times[i] = new Time(start, end);
        }
       // System.out.println("times = " + Arrays.toString(times));

        // 시작 시간을 기준으로 오름차순 정렬하되,
        // 시작 시간이 같다면, 종료 시간을 기준으로 오름차순 정렬한다.
        Arrays.sort(times, Comparator.comparingInt((Time t) -> t.start));
       // System.out.println("sortTimes = " + Arrays.toString(times));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times[0].end);

        for (int i = 1; i < n; i++) {
            // 우선순위 큐에서 가장 작은 종료 시간과
            // 현재 lectures[i]의 시작 시간을 비교한다.
            if (pq.peek() <= times[i].start) {
                pq.poll();
            }
            pq.offer(times[i].end);
        }
        System.out.println(pq.size());
    }
}
