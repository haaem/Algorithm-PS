import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2670 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double total = 0;
		double[] arr = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			double mult = 1;
			for (int j = i; j < N; j++) {
				mult *= arr[j];
				if (total < mult) {
					total = mult;
				}
			}
		}
		System.out.printf("%.3f\n", total);
	}
}
