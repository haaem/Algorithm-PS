import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11536 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		String[] sort = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
			sort[i] = arr[i];
		}
		Arrays.sort(sort);
//		System.out.println(Arrays.toString(sort));
		boolean sorted = true;
		for (int i = 0; i < n; i++) {
			if (!arr[i].equals(sort[i])) {
				sorted = false;
				break;
			}
		}
		if (sorted) {
			System.out.println("INCREASING");
			System.exit(0);
		}
		sorted = true;
		for (int i = 0; i < n; i++) {
			if (!arr[i].equals(sort[n - 1 - i])) {
				sorted = false;
				break;
			}
		}
		if (sorted) {
			System.out.println("DECREASING");
			System.exit(0);
		}
		System.out.println("NEITHER");
	}
}
