import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11116 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < n; tc++) {
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] left = new int[m];
			for (int i = 0; i < m; i++) {
				left[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int[] right = new int[m];
			for (int i = 0; i < m; i++) {
				right[i] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			for (int i = 0; i < m; i++) {
				boolean leftBack = false;
				boolean rightFront = false;
				boolean rightBack = false;
				for (int j = i + 1; j < m; j++) {
					if (left[j] == left[i] + 500) {
						leftBack = true;
						break;
					}
				}
				if (!leftBack)
					continue;
				for (int j = 0; j < m; j++) {
					if (right[j] == left[i] + 1000)
						rightFront = true;
					if (right[j] == left[i] + 1500)
						rightBack = true;
				}
				if (leftBack && rightFront && rightBack)
					count++;
			}
			System.out.println(count);
		}
	}
}
