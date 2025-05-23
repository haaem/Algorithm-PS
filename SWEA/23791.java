import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class SWEA23791 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> A = new LinkedList<Integer>();
			LinkedList<Integer> B = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				B.add(Integer.parseInt(st.nextToken()));
			}
			String[] arr = new String[N + 1];
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 1) {
					while (true) {
						int temp = A.poll();
						if (arr[temp] == null) {
							arr[temp] = "A";
							break;
						}
					}
				} else {
					while (true) {
						int temp = B.poll();
						if (arr[temp] == null) {
							arr[temp] = "B";
							break;
						}
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				sb.append(arr[i]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}