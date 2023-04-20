import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            Double d = Double.parseDouble(br.readLine());
            arr[i] = d;
        }

        double max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int i = 1; i < n; i++) {
            double v = arr[i - 1];
            for (int j = i; j < n; j++) {
                v *= arr[j];
                if (max < v)
                    max = v;
            }
        }
       System.out.printf("%.3f", Math.round(max * 1000) / 1000.0);


    }
}

