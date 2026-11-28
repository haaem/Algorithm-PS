import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String s = br.readLine();
		char[] arr = new char[n];
		for (int i = 0; i < n; i++)
			arr[i] = s.charAt(i);

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'P') {
				int start = Math.max(0, i - k);
				int end = Math.min(i + k, n - 1);

				for (int j = start; j <= end; j++) {
					if (arr[j] == 'H') {
						count++;
						arr[j] = 'N';
						break;
					}
				}
			}
		}

		System.out.println(count);
	}
}
