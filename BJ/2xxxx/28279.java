import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ28279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		LinkedList<Integer> lst = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int func = Integer.parseInt(st.nextToken());
			switch (func) {
			case 1: {
				int X = Integer.parseInt(st.nextToken());
				lst.addFirst(X);
				break;
			}
			case 2: {
				int X = Integer.parseInt(st.nextToken());
				lst.addLast(X);
				break;
			}
			case 3: {
				if (lst.size() != 0) {
					System.out.println(lst.pollFirst());
				} else {
					System.out.println(-1);
				}
				break;
			}
			case 4: {
				if (lst.size() != 0) {
					System.out.println(lst.pollLast());
				} else {
					System.out.println(-1);
				}
				break;
			}
			case 5: {
				System.out.println(lst.size());
				break;
			}
			case 6: {
				if (lst.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			}
			case 7: {
				if (lst.size() != 0) {
					System.out.println(lst.peekFirst());
				} else {
					System.out.println(-1);
				}
				break;
			}
			case 8: {
				if (lst.size() != 0) {
					System.out.println(lst.peekLast());
				} else {
					System.out.println(-1);
				}
				break;
			}
			}
		}
	}
}
