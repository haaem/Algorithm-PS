import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Part[] arr = new Part[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Part p = new Part(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				arr[i] = p;
			}
			Arrays.sort(arr);
			int ans = 1;
			int min = arr[0].i;
			for (int i = 1; i < N; i++) {
				if (arr[i].i < min) {
					min = arr[i].i;
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	public static class Part implements Comparable<Part> {
		int paper, i;

		public Part(int paper, int i) {
			this.paper = paper;
			this.i = i;
		}

		@Override
		public int compareTo(Part o) {
			return this.paper - o.paper;
		}
	}
}
