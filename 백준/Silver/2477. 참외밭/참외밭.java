import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int coordinate = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            switch (coordinate) {
                case 1 : 
                    x += length;
                    break;
                case 2 :
                    x -= length;
                    break;
                case 3 :
                    y -= length;
                    break;
                case 4 :
                    y += length;
                    break;
            }
            xList.add(x);
            yList.add(y);
        }

        ArrayList<Integer> addList = new ArrayList<>();
        ArrayList<Integer> minusList = new ArrayList<>();

        for (int i = 0; i < xList.size() - 1; i++) {
            Integer xValue = xList.get(i);
            Integer yValue = yList.get(i + 1);
            int addTotal = xValue * yValue;
            addList.add(addTotal);
        }

        for (int i = 0; i < yList.size() - 1; i++) {
            Integer xValue = xList.get(i + 1);
            Integer yValue = yList.get(i);
            int minusTotal = xValue * yValue;
            minusList.add(minusTotal);
        }

        int addListSum = 0;
        int minusListSum = 0;

        for (int i = 0; i < addList.size(); i++) {
            addListSum += addList.get(i);
        }
        for (int i = 0; i < minusList.size(); i++) {
            minusListSum += minusList.get(i);
        }

        int result = Math.abs(addListSum - minusListSum) / 2 * n;
        System.out.println(result);
    }
}