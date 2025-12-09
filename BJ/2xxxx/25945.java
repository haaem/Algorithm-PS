import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25945 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = 0;
		int[] container = new int[n];
		for (int i = 0; i < n; i++) {
			container[i] = Integer.parseInt(st.nextToken());
			m += container[i];
		}
		int avg = m / n;
		int over = 0;
		int low = 0;
		for (int i = 0; i < n; i++) {
			if (container[i] < avg) {
				low += avg - container[i];
			} else if (container[i] > avg + 1) {
				over += container[i] - avg - 1;
			}
		}
		if (low <= over) {
			System.out.println(over);
		} else {
			System.out.println(low);
		}
	}
}
